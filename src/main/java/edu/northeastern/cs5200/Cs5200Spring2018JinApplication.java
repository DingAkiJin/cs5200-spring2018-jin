package edu.northeastern.cs5200;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.web.support.SpringBootServletInitializer;

import dao.AddressDao;
import dao.DeveloperDao;
import dao.PageDao;
import dao.PhoneDao;
import dao.RoleDao;
import model.Address;
import model.Developer;
import model.Page;
import model.Phone;
import model.Role;
import dao.WebsiteDao;
import dao.WidgetDao;
import model.Website;
import model.Widget;



@SpringBootApplication
public class Cs5200Spring2018JinApplication  {
	
	//please use the following commands in the main function to test insert, update and delete
	
	public static void main(String[] args) {
		SpringApplication.run(Cs5200Spring2018JinApplication.class, args);
		
//		int insertPhoneRresult = 0;
//		insertPhoneRresult = insertPhone();
//		System.out.println("inserted " + insertPhoneRresult + " phones");
		
			
//		int insertAddressRresult = 0;
//		insertAddressRresult = insertAddress();
//		System.out.println("inserted " + insertAddressRresult + " addresses");
//		
	
//		int insertWidgetsRresult = 0;
//		insertWidgetsRresult = insertWidgets();
//		System.out.println("inserted " + insertWidgetsRresult + " widgets");
		
//		int insertPagesRresult = 0;
//		insertPagesRresult = insertPages();
//		System.out.println("inserted " + insertPagesRresult + " pages");
		
		
//		int insertWebsitesRresult = 0;
//		insertWebsitesRresult = insertWebsites();
//		System.out.println("inserted " + insertWebsitesRresult + " websites");
		
//		int insertDeveloperRresult = 0;
//		insertDeveloperRresult = insertDevelopers();
//		System.out.println("inserted " + insertDeveloperRresult + " developers");
		
//		int update0Result = 0;
//		update0Result = implementUpdate0();
//		System.out.println("updated " + update0Result + " phones");
		
		
//		int update1Result = 0;
//		update1Result = implementUpdate1();
//		System.out.println("updated " + update1Result + " widgets");
		
//		int update2Result = 0;
//		update2Result = implementUpdate2();
//		System.out.println("updated " + update2Result + " pages");
		
//		int update3Result = 0;
//		update3Result = implementUpdate3();
//		System.out.println("updated " + update3Result + " website roles");
		
//		int implementDelete1Result = 0;
//		implementDelete1Result = implementDelete1();
//		System.out.println("deleted " + implementDelete1Result + " widgets");
		
//		int implementDelete2Result = 0;
//		implementDelete2Result = implementDelete2();
//		System.out.println("deleted " + implementDelete2Result + " pages");
		
//		int implementDelete3Result = 0;
//		implementDelete3Result = implementDelete3();
//		System.out.println("deleted " + implementDelete3Result + " websites");
		
//		int implementDelete0Result = 0;
//		implementDelete0Result = implementDelete0();
//		System.out.println("deleted " + implementDelete0Result + " addresses");
	
	}
	
	public static int insertPhone() {
		int result = 0;
			PhoneDao dao = PhoneDao.getInstance();
			Phone alice1 = new Phone("123-234-3456",true,"alice",12);
			Phone alice2 = new Phone("234-345-4566",false,"alice",12);
			Phone bob1 = new Phone("345-456-5677",true,"bob",23);
			Phone charlie1 = new Phone("321-432-5435",true,"charlie",34);
			Phone charlie2 = new Phone("432-432-5433",false,"charlie",34);
			Phone charlie3 = new Phone("543-543-6544",false,"charlie",34);
		    result = dao.createPhoneForPerson(12, alice1);
			result = result + dao.createPhoneForPerson(12, alice2);
			result = result + dao.createPhoneForPerson(23, bob1);
			result = result + dao.createPhoneForPerson(34, charlie1);
			result = result + dao.createPhoneForPerson(34, charlie2);
			result = result + dao.createPhoneForPerson(34, charlie3);
		return result;
		
	}
	
	public static int insertAddress() {
		int result = 0;
			AddressDao dao = AddressDao.getInstance();
			Address alice1 = new Address("123 Adam St.","", "Alton","", "01234", false, 12);
		    Address alice2 = new Address("234 Birch St.", "","Boston","","02345", false, 12);
			Address bob1 = new Address("345 Charles St.", "","Chelms","","03455", true, 23);
			Address bob2 = new Address("456 Down St.", "","Dalton","","04566", false, 23);
			Address bob3 = new Address("543 East St.", "","Everett","","01112", false, 23);
			Address charlie1 = new Address("654 Frank St.", "","Foulton","","04322", true, 34);
		    result = dao.createAddressForPerson(12, alice1);
			result = result + dao.createAddressForPerson(12, alice2);
			result = result + dao.createAddressForPerson(23, bob1);
			result = result + dao.createAddressForPerson(23, bob2);
			result = result + dao.createAddressForPerson(23, bob3);
			result = result + dao.createAddressForPerson(34, charlie1);
		return result;
		
	}
	public static int insertDevelopers() {
		int result = 0;
		LocalDate date = LocalDate.now();
		DeveloperDao dao = DeveloperDao.getInstance();

		Developer alice = new Developer(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com", date.toString(),
				"4321rewq");
		Developer bob = new Developer(23, "Bob", "Marley", "bob", "bob", "bob@marley.com", date.toString(), "5432trew");
		Developer charlie = new Developer(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com",
				date.toString(), "6543ytre");
		Developer dan = new Developer(45, "Dan", "Martin", "dan", "dan", "dan@martin.com", date.toString(), "7654fda");
		Developer ed = new Developer(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com", date.toString(), "5678dfgh");

		result = dao.createDeveloper(alice);
		result = result + dao.createDeveloper(bob);
		result = result + dao.createDeveloper(charlie);
		result = result + dao.createDeveloper(dan);
		result = result + dao.createDeveloper(ed);

		return result;
	}
	
public static int insertWebsites() {

		final int ADMIN = 1;
		final int EDITOR = 2;
		final int OWNER = 3;
		final int REVIEWER = 4;
		final int WRITER = 5;
		int websiteResult = 0;
		int roleResult = 0;
		LocalDate date = LocalDate.now();
		WebsiteDao websiteDao = WebsiteDao.getInstance();
     	RoleDao roleDao = RoleDao.getInstance();

		Website Facebook = new Website(123, "Facebook", "an online social media and social networking service",
				date.toString(), date.toString(), 1234234, 12);
		Website Twitter = new Website(234, "Twitter", "an online news and social networking service", date.toString(),
				date.toString(), 4321543, 23);
		Website Wikipedia = new Website(345, "Wikipedia", "a free online encyclopedia", date.toString(),
				date.toString(), 3456654, 34);
		Website CNN = new Website(456, "CNN", "an American basic cable and satellite television news channel",
				date.toString(), date.toString(), 6543345, 12);
		Website CNET = new Website(567, "CNET",
				"an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics",
				date.toString(), date.toString(), 5433455, 23);
		Website Gizmodo = new Website(678, "Gizmodo",
				"a design, technology, science and science fiction website that also writes articles on politics",
				date.toString(), date.toString(), 4322345, 34);

		websiteResult = websiteDao.createWebsiteForDeveloper(Facebook.getDeveloperId(), Facebook);
		websiteResult = websiteResult + websiteDao.createWebsiteForDeveloper(Twitter.getDeveloperId(), Twitter);
		websiteResult = websiteResult + websiteDao.createWebsiteForDeveloper(Wikipedia.getDeveloperId(), Wikipedia);
		websiteResult = websiteResult + websiteDao.createWebsiteForDeveloper(CNN.getDeveloperId(), CNN);
		websiteResult = websiteResult + websiteDao.createWebsiteForDeveloper(CNET.getDeveloperId(), CNET);
		websiteResult = websiteResult + websiteDao.createWebsiteForDeveloper(Gizmodo.getDeveloperId(), Gizmodo);

		roleResult = roleDao.assignWebsiteRole(12, 123, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 123, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(34, 123, ADMIN);
		
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 234, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(34, 234, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(12, 234, ADMIN);

		roleResult = roleDao.assignWebsiteRole(34, 345, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(12, 345, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 345, ADMIN);
		
		roleResult = roleResult + roleDao.assignWebsiteRole(12, 456, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 456, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(34, 456, ADMIN);
		
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 567, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(34, 567, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(12, 567, ADMIN);
		
		roleResult = roleResult + roleDao.assignWebsiteRole(34, 678, OWNER);
		roleResult = roleResult + roleDao.assignWebsiteRole(12, 678, EDITOR);
		roleResult = roleResult + roleDao.assignWebsiteRole(23, 678, ADMIN);
		
		return websiteResult;
	}
	
public static int insertPages() {
		
		final int ADMIN = 1;
		final int EDITOR = 2;
		final int OWNER = 3;
		final int REVIEWER = 4;
		final int WRITER = 5;

		int pageResult = 0;
		int roleResult = 0;
		LocalDate date = LocalDate.now();
		PageDao dao = PageDao.getInstance();
	    RoleDao roleDao = RoleDao.getInstance();

		Page Home = new Page(123, "Home", "Landing page", date.toString(), date.toString(), 123434, 567);
		Page About = new Page(234, "About", "Website description", date.toString(), date.toString(), 234545, 678);
		Page Contact = new Page(345, "Contact", "Addresses, phones, and contact info", date.toString(), date.toString(),
				345656, 345);
		Page Preferences = new Page(456, "Preferences", "Where users can configure their preferences", date.toString(),
				date.toString(), 456776, 456);
		Page Profile = new Page(567, "Profile", "Users can configure their personal information", date.toString(),
				date.toString(), 567878, 567);

		pageResult = dao.createPageForWebsite(Home.getWebsiteId(), Home);
		pageResult = pageResult + dao.createPageForWebsite(About.getWebsiteId(), About);
		pageResult = pageResult + dao.createPageForWebsite(Contact.getWebsiteId(), Contact);
		pageResult = pageResult + dao.createPageForWebsite(Preferences.getWebsiteId(), Preferences);
		pageResult = pageResult + dao.createPageForWebsite(Profile.getWebsiteId(), Profile);

		roleResult = roleDao.assignPageRole(12, 123, OWNER);
		roleResult = roleResult + roleDao.assignPageRole(23, 123, REVIEWER);
		roleResult = roleResult + roleDao.assignPageRole(34, 123, WRITER);
		
		roleResult = roleResult + roleDao.assignPageRole(23, 234, OWNER);
		roleResult = roleResult + roleDao.assignPageRole(34, 234, REVIEWER);
		roleResult = roleResult + roleDao.assignPageRole(12, 234, WRITER);

		roleResult = roleDao.assignPageRole(34, 345, OWNER);
		roleResult = roleResult + roleDao.assignPageRole(12, 345, REVIEWER);
		roleResult = roleResult + roleDao.assignPageRole(23, 345, WRITER);
		
		roleResult = roleResult + roleDao.assignPageRole(12, 456, OWNER);
		roleResult = roleResult + roleDao.assignPageRole(23, 456, REVIEWER);
		roleResult = roleResult + roleDao.assignPageRole(34, 456, WRITER);
		
		roleResult = roleResult + roleDao.assignPageRole(23, 567, OWNER);
		roleResult = roleResult + roleDao.assignPageRole(34, 567, REVIEWER);
		roleResult = roleResult + roleDao.assignPageRole(12, 567, WRITER);
		
		return pageResult;
	}

public static int insertWidgets() {
	int result = 0;
	WidgetDao dao = WidgetDao.getInstance();

	Widget head123 = new Widget(123, "head123", 0, 0, null, null, "Welcome", 0, "Heading", null, false, false,
			null, 0, null, 123);
	Widget post234 = new Widget(234, "post234", 0, 0, null, null, "Lorem", 0, "Html", null, false, false,
			null, 0, null, 234);
	Widget head345 = new Widget(345, "head345", 0, 0, null, null, "Hi", 1, "Heading", null, false, false,
			null, 0, null, 345);
	Widget intro456 = new Widget(456, "intro456", 0, 0, null, null, "<h1>Hi</h1>", 2, "Html", null, false,
			false, null, 0, null, 345);
	Widget image345 = new Widget(567, "image345", 50, 100, null, null, null, 3, "Image", null, false, false,
			"/img/567.png", 0, null, 345);
	Widget video456 = new Widget(678, "video456", 400, 300, null, null, null, 0, "YouTube",
			"https://youtu.be/h67VX51QXiQ", false, false, null, 0, null, 456);

	result = dao.createWidgetForPage(head123.getPageId(), head123);
	result = result + dao.createWidgetForPage(post234.getPageId(), post234);
	result = result + dao.createWidgetForPage(head345.getPageId(), head345);
	result = result + dao.createWidgetForPage(intro456.getPageId(), intro456);
	result = result + dao.createWidgetForPage(image345.getPageId(), image345);
	result = result + dao.createWidgetForPage(video456.getPageId(), video456);

	return result;
}

//update phone
public static int implementUpdate0() {
	int result = 0;
	PhoneDao dao = PhoneDao.getInstance();
	Phone phone = new Phone("333-444-5555",true,"charlie",34);
	result =dao.updatePrimaryPhone("charlie", phone);
	return result;
}

//update the relative oder of widgets
public static int implementUpdate1() {
	int result = 0;
	WidgetDao dao = WidgetDao.getInstance();
	List<Widget> widgets = dao.findAllWidgets();
	Widget head345Widget = new Widget();
	
	for(int i = 0; i < widgets.size(); i++) {
		if(widgets.get(i).getName().equals("head345")) {
			head345Widget = widgets.get(i);
		}				
	}
	List<Widget> allPageWidgets = dao.findWidgetsForPage(head345Widget.getPageId());
	
	for(int i= 0; i< allPageWidgets.size(); i++) {
		if(allPageWidgets.get(i).getOrder() > head345Widget.getOrder() && allPageWidgets.get(i).getOrder() <= 3) {
			Widget curr = allPageWidgets.get(i);
			System.out.println(i);
			int order = curr.getOrder()-1;
			curr.setOrder(order);
			result = result + dao.updateWidget(curr.getId(), curr);
			}
	}
	
	head345Widget.setOrder(3);
	result = result + dao.updateWidget(head345Widget.getId(), head345Widget);
	return result;
}

//update the developer
public static int implementUpdate2() {
	int result = 0;

	WebsiteDao websiteDao = WebsiteDao.getInstance();
	List<Website> websites = websiteDao.findAllWebsites();
	Website CNET = new Website();
	
	for(int i = 0; i < websites.size(); i++) {
		if(websites.get(i).getName().equals("CNET")) {
			CNET = websites.get(i);
		}				
	}
	
	PageDao pageDao = PageDao.getInstance();
	List<Page> pages = pageDao.findPagesForWebsite(CNET.getId());
	for(int i = 0; i < pages.size(); i++) {
		pages.get(i).setTitle("CNET - " + pages.get(i).getTitle());	
		result = result +pageDao.updatePage(pages.get(i).getId(), pages.get(i));
	}
	
	return result;
}

//update the roles
public static int implementUpdate3() {
	int result = 0;

	WebsiteDao websiteDao = WebsiteDao.getInstance();
	List<Website> websites = websiteDao.findAllWebsites();
	Website CNET = new Website();
	
	for(int i = 0; i < websites.size(); i++) {
		if(websites.get(i).getName().equals("CNET")) {
			CNET = websites.get(i);
		}				
	}
	
	PageDao pageDao = PageDao.getInstance();
	List<Page> pages = pageDao.findPagesForWebsite(CNET.getId());
	Page CNETHomePage = new Page();
	
	for(int i = 0; i < pages.size(); i++) {
		if(pages.get(i).getTitle().equals("Home") ) {
			CNETHomePage = pages.get(i);
		}				
	}
	
	
	DeveloperDao developerDao = DeveloperDao.getInstance();
	RoleDao roleDao = RoleDao.getInstance();
	List<Role> roles = roleDao.findPageRoleByPageId(CNETHomePage.getId());
	Role charlieRole = new Role();
	Role bobRole = new Role();
	
	for(int i = 0; i < roles.size(); i++) {
		Developer developer = developerDao.findDeveloperById(roles.get(i).getDeveloperId());
		if(developer.getUsername().equals("charlie")) {
			charlieRole = roles.get(i);
		} else if (developer.getUsername().equals("bob")) {
			bobRole = roles.get(i);
		}
	}
	
	int tempRole = -1;
	tempRole = charlieRole.getRoleId();
	charlieRole.setRoleId(bobRole.getRoleId());
	bobRole.setRoleId(tempRole);
	
	result = roleDao.updatePageRole(charlieRole.getId(), charlieRole);
	result = result + roleDao.updatePageRole(bobRole.getId(), bobRole);
	
	
	return result;
}
//delete address

public static int implementDelete0() {
	int result = 0;
	DeveloperDao developerdao = DeveloperDao.getInstance();
	Developer dev =developerdao.findDeveloperByUsername("alice");
	
	AddressDao dao = AddressDao.getInstance();
	result = dao.deletePrimaryAddress(dev.getId());
	return result;
}
//delete widget
public static int implementDelete1() {
	int result = 0;

	PageDao pageDao = PageDao.getInstance();
	List<Page> pages = pageDao.findAllPages();
	Page contactPage = new Page();
	for(int i = 0; i < pages.size(); i++) {
		if(pages.get(i).getTitle().equals("Contact")) {
			contactPage = pages.get(i);
		}				
	}
	
	WidgetDao widgetDao = WidgetDao.getInstance();
	List<Widget> widgets = widgetDao.findWidgetsForPage(contactPage.getId());
	Widget lastWidget = new Widget();
	
	for(int i = 0; i < widgets.size(); i++) {
		if(widgets.get(i).getOrder() > lastWidget.getOrder()) {
			lastWidget = widgets.get(i);
		}				
	}
	
	result = widgetDao.deleteWidget(lastWidget.getId());
	
	return result;
}
//delete page
public static int implementDelete2() {
	int result = 0;

	WebsiteDao websiteDao = WebsiteDao.getInstance();
	List<Website> websites = websiteDao.findAllWebsites();
	Website Wikipedia = new Website();
	
	for(int i = 0; i < websites.size(); i++) {
		if(websites.get(i).getName().equals("Wikipedia")) {
			Wikipedia = websites.get(i);
		}				
	}
	
	PageDao pageDao = PageDao.getInstance();
	List<Page> pages = pageDao.findPagesForWebsite(Wikipedia.getId());
	
	Page lastUpadatedPage = new Page();
	lastUpadatedPage.setUpdated("0");
	for(int i = 0; i < pages.size(); i++) {
		
		  String d1 = pages.get(i).getUpdated().replace("-", "");
		  String d2 = lastUpadatedPage.getUpdated().replace("-", "");
		  if(d1.compareTo(d2) > 0) {
			  lastUpadatedPage = pages.get(i);
		  }
		  
	}
	
	result = pageDao.deletePage(lastUpadatedPage.getId());
	
	return result;
}
//delete website as well as related roles and priviledges
public static int implementDelete3() {
	int result = 0;

	WebsiteDao websiteDao = WebsiteDao.getInstance();
	List<Website> websites = websiteDao.findAllWebsites();
	Website CNET = new Website();
	
	for(int i = 0; i < websites.size(); i++) {
		if(websites.get(i).getName().equals("CNET")) {
			CNET = websites.get(i);
		}				
	}
	
	result = websiteDao.deleteWebsite(CNET.getId());
	
	return result;
}

}
