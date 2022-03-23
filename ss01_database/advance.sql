-- Cau 21
create view v_nhan_vien as
Select distinct nv.*
from nhan_vien nv inner join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where (dia_chi like "%Hải Châu%" and date(ngay_lam_hop_dong) = 12 and month(ngay_lam_hop_dong) = 12 and year(ngay_lam_hop_dong) = 2019);

-- Cau 22
UPDATE v_nhan_vien
 SET dia_chi = "Liên Chiểu";
 
 -- Cau 23
DELIMITER //
-- Drop procedure if exists sp_xoa_khach_hang;
Create PROCEDURE sp_xoa_khach_hang(in in_ma_khach_hang int)
BEGIN
   DELETE  FROM khach_hang WHERE ma_khach_hang = in_ma_khach_hang;
END; 
// delimiter
call sp_xoa_khach_hang(4)

-- Cau 24
DELIMITER //
Drop procedure if exists sp_them_moi_hop_dong;
Create PROCEDURE sp_them_moi_hop_dong(
	in in_ma_hop_dong int,
    in in_ngay_lam_hop_dong datetime,
    in in_ngay_ket_thuc datetime,
    in in_tien_dat_coc int,
    in in_ma_nhan_vien int,
    in in_ma_khach_hang int,
    in in_ma_dich_vu int)
BEGIN
	If (in_ma_hop_dong in (Select ma_hop_dong from hop_dong)) then
		signal SQLSTATE '45000' SET MESSAGE_TEXT = 'Ma hop dong da ton tai';
	end if;
	If (date(in_ngay_ket_thuc) - date(in_ngay_lam_hop_dong) < 0) then
		signal SQLSTATE '45000' SET MESSAGE_TEXT = 'Ngay ket thuc phai sau ngay lam hop dong';
	end if;
	If (in_ma_nhan_vien not in (Select ma_nhan_vien from nhan_vien)) then
		signal SQLSTATE '45000' SET MESSAGE_TEXT =  'Ma nhan vien khong ton tai';
	end if;
	If (in_ma_khach_hang not in (Select ma_khach_hang from khach_hang)) then
		signal SQLSTATE '45000' SET MESSAGE_TEXT =  'Ma khach hang khong ton tai';
	end if;
	If (in_ma_dich_vu not in (Select ma_dich_vu from dich_vu)) then
		signal SQLSTATE '45000' SET MESSAGE_TEXT =  'Ma dich vu khong ton tai';
	end if;
	Insert into hop_dong values (in_ma_hop_dong,
								in_ngay_lam_hop_dong,
                                in_ngay_ket_thuc,
                                in_tien_dat_coc,
                                in_ma_nhan_vien,
                                in_ma_khach_hang,
								in_ma_dich_vu);
END;
// delimiter ;
 call sp_them_moi_hop_dong(14, "2021-01-14", "2021-01-14", 100000, 20, 1, 1);

-- Cau 25
delimiter //
Drop trigger if exists tr_xoa_hop_dong;
Create trigger tr_xoa_hop_dong after delete on hop_dong
for each row
begin
	declare total_record int;
    set total_record = (select count(*) from hop_dong);
    -- signal sqlstate '45000' set message_text = total_record;
	-- SELECT total_record AS LOG INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/log.txt';
end;
// delimiter ;
-- Delete from hop_dong where ma_hop_dong = 4;
-- Insert into hop_dong values (4,	"2021-01-14",	"2021-01-18",	100000,	7,	5,	5)

-- Cau 26
delimiter //
Drop trigger if exists tr_cap_nhat_hop_dong;
Create trigger tr_cap_nhat_hop_dong before update on hop_dong
for each row
begin
	if(date(new.ngay_ket_thuc) - date(new.ngay_lam_hop_dong) < 2) then
		signal sqlstate '45000' set message_text = "Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày";
	end if;
end;
// delimiter ;
-- update hop_dong set ngay_ket_thuc = '2021-05-25'
-- where ma_hop_dong = 12;

-- Cau 27.a
drop function func_dem_dich_vu
delimiter //
create function func_dem_dich_vu()
returns int
deterministic
MODIFIES SQL DATA
CONTAINS SQL
begin
	declare count_greater_2m int;
    drop table if exists tmp_table;
    create table tmp_table(total_cost int);
    insert into tmp_table select count(hd.ma_dich_vu)*chi_phi_thue as total_cost 
															from hop_dong hd inner join dich_vu dv
															on hd.ma_dich_vu = dv.ma_dich_vu
															group by hd.ma_dich_vu;
	select count(*) into count_greater_2m from tmp_table where total_cost > 2000000;
	return count_greater_2m;
end;
// delimiter ;
select func_dem_dich_vu() as total;

-- Cau 28
Delimiter //
drop procedure if exists sp_xoa_dich_vu_va_hd_room;
create procedure sp_xoa_dich_vu_va_hd_room()
begin
	drop table if exists tmp_table;
	create table tmp_table(ma_hop_dong int, ma_dich_vu int);
	insert into tmp_table Select ma_hop_dong, dv.ma_dich_vu from hop_dong hd left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
										inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
							where (ten_loai_dich_vu = "Room") and (year(ngay_lam_hop_dong) in (2015, 2016, 2017, 2018, 2019));
	delete from hop_dong_chi_tiet where ma_hop_dong in (select ma_hop_dong from tmp_table);
    delete from hop_dong where ma_hop_dong in (select ma_hop_dong from tmp_table);
    delete from dich_vu where ma_dich_vu in (select ma_dich_vu from tmp_table);
end;
// delimiter ;
call sp_xoa_dich_vu_va_hd_room();
