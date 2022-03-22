-- Cau 2
Select * from nhan_vien where (nhan_vien.ho_ten like "H%" or
								nhan_vien.ho_ten like "T%" or
                                nhan_vien.ho_ten like "K%") and char_length(nhan_vien.ho_ten) <=15;
                                
-- Cau 3
Select * from khach_hang where ((YEAR(CURDATE()) - YEAR(khach_hang.ngay_sinh)) >= 18 and (YEAR(CURDATE()) - YEAR(khach_hang.ngay_sinh)) <=50) 
										and (khach_hang.dia_chi like "%Đà Nẵng%" or khach_hang.dia_chi like "%Quảng Trị%");

-- Cau 4
Select kh.ma_khach_hang, kh.ho_ten, count(kh.ho_ten) as so_lan_dat_phong
from khach_hang kh inner join  hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
								inner join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where lk.ten_loai_khach = "Diamond"
group by kh.ho_ten
order by count(kh.ho_ten) asc;

-- Cau 5
Select  kh.ma_khach_hang, ho_ten, ten_loai_khach, hd.ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, ifnull((chi_phi_thue+ifnull(sum(so_luong*gia), 0)), 0) as tong_tien
from khach_hang kh left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang 
				left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
				left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by kh.ma_khach_hang
order by kh.ma_khach_hang asc;

-- Cau 6
Select distinct dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
from dich_vu dv  inner join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in (Select dv.ma_dich_vu 
		from dich_vu dv inner join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
        where Year(ngay_lam_hop_dong) = 2021 and (month(ngay_lam_hop_dong) = 1 or month(ngay_lam_hop_dong) = 2 or month(ngay_lam_hop_dong) = 3));

-- Cau 7
Select ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu dv inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where ma_dich_vu in (Select dv.ma_dich_vu
from dich_vu dv inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where (year(ngay_lam_hop_dong)=2020))
and ma_dich_vu not in (Select dv.ma_dich_vu
from dich_vu dv inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where (year(ngay_lam_hop_dong)=2021));

-- Cau 8
  -- Cách 1:
Select distinct * from khach_hang;
  -- Cách 2:
Select * from khach_hang group by ho_ten;

-- Cau 9
select month(ngay_lam_hop_dong) as thang, count(*) so_luong_khach_hang
from hop_dong
where year(ngay_lam_hop_dong) = 2021
group by thang
order by thang asc;

-- Cau 10
Select distinct hd.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ifnull(sum(so_luong), 0) as so_luong_dich_vu_di_kem
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
				left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by hd.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc
order by hd.ma_hop_dong asc;

-- Cau 11
Select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem
from dich_vu_di_kem dvdk inner join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
						inner join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
                        inner join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
                        inner join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where (dia_chi like "%Vinh%") or (dia_chi like "%Quảng Ngãi%") and (ten_loai_khach = "Diamond");

-- Cau 12
Select hd.ma_hop_dong, nv.ho_ten as ho_ten_nhan_vien, kh.ho_ten as ho_ten_khach_hang, kh.so_dien_thoai, ten_dich_vu, ifnull(sum(so_luong), 0) as so_luong_dich_vu_di_kem, tien_dat_coc
from dich_vu dv right join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
				left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
				inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
                inner join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
where dv.ma_dich_vu in (select dv.ma_dich_vu from dich_vu dv inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
					where (year(ngay_lam_hop_dong)=2020 and month(ngay_lam_hop_dong) in ("10", "11", "12")))
and dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv inner join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
					where (year(ngay_lam_hop_dong)=2021 and month(ngay_lam_hop_dong) in (1, 2, 3, 4, 5, 6)))
group by hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, ten_dich_vu;

-- Cau 13*
Select s.ma_dich_vu_di_kem, s.ten_dich_vu_di_kem, Max(s.so_luong_su_dung) as so_luong_su_dung from (Select hdct.ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) as so_luong_su_dung
from  dich_vu_di_kem dvdk inner join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hdct.ma_dich_vu_di_kem) as s;

-- Cau 14
Select hdct.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_luong_su_dung
from dich_vu_di_kem dvdk inner join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
						inner join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
                        inner join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                        inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
group by ten_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1
order by hdct.ma_hop_dong asc;

-- Cau 15
Select distinct nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv inner join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
				inner join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
				inner join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
group by hd.ma_nhan_vien
having count(hd.ma_nhan_vien) <= 3;

-- Cau 16
Delete from nhan_vien
where ma_nhan_vien not in (Select nv.ma_nhan_vien
from nhan_vien nv inner join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where (year(ngay_lam_hop_dong) in (2019, 2020, 2021)));

-- Cau 17


-- Cau 18
Delete from khach_hang where ma_khach_hang in (Select kh.ma_khach_hang
from khach_hang kh inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where (year(ngay_lam_hop_dong)<2021));

-- Cau 19
SET SQL_SAFE_UPDATES=0;
Update furama_danang.dich_vu_di_kem
set gia = gia*2
where ma_dich_vu_di_kem in (select ma_dich_vu_di_kem
from hop_dong_chi_tiet hdct inner join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
where (year(ngay_lam_hop_dong) = 2020 and so_luong>=10));
SET SQL_SAFE_UPDATES=1;

-- Cau 20
Select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union
select ma_khach_hang as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang