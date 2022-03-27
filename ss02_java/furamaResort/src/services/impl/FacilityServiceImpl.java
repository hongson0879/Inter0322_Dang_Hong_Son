package services.impl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;
import utils.RegexData;

public class FacilityServiceImpl implements FacilityService{
	public static final String REGEX_STR = "[A-Z][a-z]+";
	public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
	public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
	public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
	public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|20$";
	public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
	public static final String REGEX_ACREAGE = "^([3-9]\\d|[1-9]\\d{2,})$";
	
	private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap();
	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public void display() {
		for(Facility facility : facilityIntegerMap.keySet()) {
			System.out.println("Service: " + facility.toString() + ", Number of rental: " + facilityIntegerMap.get(facility));
		}
	}

	@Override
	public void addNew() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaintain() {
		System.out.println("Services that need maintanance: ");
		for(Facility facility : facilityIntegerMap.keySet()) {
			if (facilityIntegerMap.get(facility) == 5) {
				System.out.println("Service: " + facility.toString());
			}
		}
	}
	
	private String inputIdVilla() {
		System.out.println("Enter facility ID: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_ID_VILLA, "You enter the invalid ID, "
									+ " facility ID must be in the form SVVL-YYYY");
	}
	private String inputIdHouse() {
		System.out.println("Enter facility ID: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_ID_HOUSE, "You enter the invalid ID, "
									+ " facility ID must be in the form SVHO-YYYY");
	}
	private String inputIdRoom() {
		System.out.println("Enter facility ID: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_ID_ROOM, "You enter the invalid ID, "
									+ " facility ID must be in the form SVRO-YYYY");
	}
	
	private String inputName() {
		System.out.println("Enter facility name: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_STR, "You enter the invalid name, "
									+ " the first letter of the facility name must be capitalized");
	}
	
	private String inputAcreage() {
		System.out.println("Enter facility acreage: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_ACREAGE, "You enter the invalid name, "
									+ " the acreage must greater than 30");
	}
	
	private String inputRentalCost() {
		System.out.println("Enter facility rental cost: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_INT, "You enter the invalid name, "
									+ " the rental cose must greater than 0");
	}
	
	private String inputMaxPeople() {
		System.out.println("Enter facility max of people number: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_AMOUNT, "You enter the invalid name, "
									+ " the max of people number must greater than 0 and less than 20");
	}
	
	private String inputFloorsNumber() {
		System.out.println("Enter facility floors number: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_INT, "You enter the invalid name, "
									+ " the floors number must greater than 0");
	}
	
	private String inputRentalType() {
		System.out.println("Enter facility rental type: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_STR, "You enter the invalid name, "
									+ " the first letter of the facility rental type must be capitalized");
	}
	
	private String inputRoomStandard() {
		System.out.println("Enter facility room standare: ");
		return RegexData.regexStr(scan.nextLine(), REGEX_STR, "You enter the invalid name, "
									+ " the first letter of the facility room standard must be capitalized");
	}
	

	@Override
	public void addNewVilla() {
		String facilityID = inputIdVilla();
		String facilityName = inputName();
		int acreage = Integer.parseInt(inputAcreage());
		int rentalCost = Integer.parseInt(inputRentalCost());
		int maxPeopleNumber = Integer.parseInt(inputMaxPeople());
		String rentalType = inputRentalType();
		String roomStandard = inputRoomStandard();
		System.out.println("Enter pool area: ");
		int poolArea = Integer.parseInt(scan.nextLine());
		int floorsNumber = Integer.parseInt(inputFloorsNumber());
		Villa villa = new Villa(facilityID, 
								facilityName,
								acreage, 
								rentalCost, 
								maxPeopleNumber, 
								rentalType, 
								roomStandard, 
								poolArea, 
								floorsNumber);
		facilityIntegerMap.put(villa, 5);
		System.out.println("Add new villa successfully!");
	}

	@Override
	public void addNewHouse() {
		String facilityID = inputIdHouse();
		String facilityName = inputName();
		int acreage = Integer.parseInt(inputAcreage());
		int rentalCost = Integer.parseInt(inputRentalCost());
		int maxPeopleNumber = Integer.parseInt(inputMaxPeople());
		String rentalType = inputRentalType();
		System.out.println("Enter pool area: ");
		int poolArea = Integer.parseInt(scan.nextLine());
		int floorsNumber = Integer.parseInt(inputFloorsNumber());
		House house = new House(facilityID, 
								facilityName,
								acreage, 
								rentalCost, 
								maxPeopleNumber, 
								rentalType, 
								poolArea, 
								floorsNumber);
		facilityIntegerMap.put(house, 0);
		System.out.println("Add new house successfully!");
		
	}

	@Override
	public void addNewRoom() {
		String facilityID = inputIdHouse();
		String facilityName = inputName();
		int acreage = Integer.parseInt(inputAcreage());
		int rentalCost = Integer.parseInt(inputRentalCost());
		int maxPeopleNumber = Integer.parseInt(inputMaxPeople());
		String rentalType = inputRentalType();
		System.out.println("Enter free service: ");
		String freeService = scan.nextLine();
		Room room = new Room(facilityID, 
								facilityName,
								acreage, 
								rentalCost, 
								maxPeopleNumber, 
								rentalType, 
								freeService);
		facilityIntegerMap.put(room, 0);
		System.out.println("Add new room successfully!");		
	}

}
