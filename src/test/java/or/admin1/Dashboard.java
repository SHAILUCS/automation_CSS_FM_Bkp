package or.admin1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.webdriver.DriverFactory;

public class Dashboard {
	
	public static String url = "index.php/dashboard";
	
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "aboutDisplayLink")
    public WebElement about;

    @FindBy(id = "menu_maintenance_accessEmployeeData")
    public WebElement accessRecords;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployee;

    @FindBy(id = "menu_leave_addLeaveEntitlement")
    public WebElement addEntitlements;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement admin;

    @FindBy(id = "menu_leave_applyLeave")
    public WebElement apply;

    @FindBy(css = "#dashboard-quick-launch-panel-menu_holder table.quickLaungeContainer tbody tr td:nth-of-type(4) div.quickLaunge a")
    public WebElement applyLeave;

    @FindBy(id = "menu_leave_assignLeave")
    public WebElement assignLeave1;

    @FindBy(css = "#dashboard-quick-launch-panel-menu_holder table.quickLaungeContainer tbody tr td:nth-of-type(1) div.quickLaunge a")
    public WebElement assignLeave2;

    @FindBy(id = "menu_attendance_Attendance")
    public WebElement attendance;

    @FindBy(id = "menu_time_displayAttendanceSummaryReportCriteria")
    public WebElement attendanceSummary;

    @FindBy(id = "menu_buzz_viewBuzz")
    public WebElement buzz;

    @FindBy(id = "addCancel")
    public WebElement cancel;

    @FindBy(id = "menu_maintenance_purgeCandidateData")
    public WebElement candidateRecords;

    @FindBy(id = "menu_recruitment_viewCandidates")
    public WebElement candidates;

    @FindBy(id = "menu_admin_Configuration")
    public WebElement configuration1;

    @FindBy(id = "menu_pim_Configuration")
    public WebElement configuration2;

    @FindBy(id = "menu_attendance_configure")
    public WebElement configuration3;

    @FindBy(id = "menu_leave_Configure")
    public WebElement configure1;

    @FindBy(id = "menu_performance_Configure")
    public WebElement configure2;

    @FindBy(id = "menu_pim_listCustomFields")
    public WebElement customFields;

    @FindBy(id = "menu_admin_viewCustomers")
    public WebElement customers;

    @FindBy(id = "menu_dashboard_index")
    public WebElement dashboard;

    @FindBy(id = "menu_admin_pimCsvImport")
    public WebElement dataImport;

    @FindBy(id = "menu_directory_viewDirectory")
    public WebElement directory;

    @FindBy(id = "menu_admin_viewEducation")
    public WebElement education;

    @FindBy(id = "menu_admin_listMailConfiguration")
    public WebElement emailConfiguration;

    @FindBy(id = "menu_admin_viewEmailNotification")
    public WebElement emailSubscriptions;

    @FindBy(id = "menu_leave_viewLeaveEntitlements")
    public WebElement employeeEntitlements;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;

    @FindBy(id = "menu_attendance_viewAttendanceRecord")
    public WebElement employeeRecords1;

    @FindBy(id = "menu_maintenance_purgeEmployee")
    public WebElement employeeRecords2;

    @FindBy(id = "menu_time_displayEmployeeReportCriteria")
    public WebElement employeeReports;

    @FindBy(id = "menu_time_viewEmployeeTimesheet")
    public WebElement employeeTimesheets;

    @FindBy(id = "menu_performance_viewEmployeePerformanceTrackerList")
    public WebElement employeeTrackers;

    @FindBy(id = "menu_admin_employmentStatus")
    public WebElement employmentStatus;

    @FindBy(id = "menu_leave_Entitlements")
    public WebElement entitlements;

    @FindBy(id = "menu_admin_viewOrganizationGeneralInformation")
    public WebElement generalInformation;

    @FindBy(id = "menu_leave_viewHolidayList")
    public WebElement holidays;

    @FindBy(id = "menu_admin_Job")
    public WebElement job;

    @FindBy(id = "menu_admin_jobCategory")
    public WebElement jobCategories;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitles;

    @FindBy(id = "menu_performance_searchKpi")
    public WebElement kpis;

    @FindBy(id = "menu_admin_languagePackage")
    public WebElement languagePackages;

    @FindBy(id = "menu_admin_viewLanguages")
    public WebElement languages;

    @FindBy(id = "menu_leave_viewLeaveModule")
    public WebElement leave;

    @FindBy(id = "menu_leave_viewLeaveBalanceReport")
    public WebElement leaveEntitlementsAndUsageReport;

    @FindBy(id = "menu_leave_viewLeaveList")
    public WebElement leaveList1;

    @FindBy(css = "a[href='/index.php/leave/viewLeaveList']")
    public WebElement leaveList2;

    @FindBy(id = "menu_leave_defineLeavePeriod")
    public WebElement leavePeriod;

    @FindBy(id = "menu_leave_leaveTypeList")
    public WebElement leaveTypes;

    @FindBy(id = "menu_admin_viewLicenses")
    public WebElement licenses;

    @FindBy(id = "menu_admin_localization")
    public WebElement localization;

    @FindBy(id = "menu_admin_viewLocations")
    public WebElement locations;

    @FindBy(css = "a[href='/index.php/auth/logout']")
    public WebElement logout;

    @FindBy(id = "menu_maintenance_purgeEmployee")
    public WebElement maintenance;

    @FindBy(id = "menu_performance_ManageReviews")
    public WebElement manageReviews1;

    @FindBy(id = "menu_performance_searchPerformancReview")
    public WebElement manageReviews2;

    @FindBy(id = "MP_link")
    public WebElement marketplace;

    @FindBy(id = "menu_admin_membership")
    public WebElement memberships;

    @FindBy(id = "menu_admin_viewModules")
    public WebElement modules;

    @FindBy(id = "menu_leave_viewMyLeaveEntitlements")
    public WebElement myEntitlements;

    @FindBy(id = "menu_pim_viewMyDetails")
    public WebElement myInfo;

    @FindBy(id = "menu_leave_viewMyLeaveList")
    public WebElement myLeave1;

    @FindBy(css = "a[href='/index.php/leave/viewMyLeaveList']")
    public WebElement myLeave2;

    @FindBy(id = "menu_leave_viewMyLeaveBalanceReport")
    public WebElement myLeaveEntitlementsAndUsageReport;

    @FindBy(id = "menu_attendance_viewMyAttendanceRecord")
    public WebElement myRecords;

    @FindBy(id = "menu_performance_myPerformanceReview")
    public WebElement myReviews;

    @FindBy(css = "#dashboard-quick-launch-panel-menu_holder table.quickLaungeContainer tbody tr td:nth-of-type(6) div.quickLaunge a")
    public WebElement myTimesheet;

    @FindBy(id = "menu_time_viewMyTimesheet")
    public WebElement myTimesheets;

    @FindBy(id = "menu_performance_viewMyPerformanceTrackerList")
    public WebElement myTrackers;

    @FindBy(id = "menu_admin_nationality")
    public WebElement nationalities;

    @FindBy(css = "#togglConfirm div:nth-of-type(3) input:nth-of-type(1)")
    public WebElement ok;

    @FindBy(id = "menu_pim_configurePim")
    public WebElement optionalFields;

    @FindBy(css = "a[href='http://www.orangehrm.com/']")
    public WebElement orangehrm;

    @FindBy(css = "a[href='http://www.orangehrm.com']")
    public WebElement orangehrmInc;

    @FindBy(id = "menu_admin_Organization")
    public WebElement organization;

    private final String pageLoadedText = "My Leave Entitlements and Usage Report";

    private final String pageUrl = "/index.php/dashboard";

    @FindBy(id = "menu_admin_viewPayGrades")
    public WebElement payGrades;

    @FindBy(id = "menu__Performance")
    public WebElement performance;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pim;

    @FindBy(id = "menu_admin_ProjectInfo")
    public WebElement projectInfo;

    @FindBy(id = "menu_time_displayProjectReportCriteria")
    public WebElement projectReports;

    @FindBy(id = "menu_admin_viewProjects")
    public WebElement projects;

    @FindBy(id = "menu_attendance_punchIn")
    public WebElement punchInout;

    @FindBy(id = "menu_maintenance_PurgeRecords")
    public WebElement purgeRecords;

    @FindBy(id = "menu_admin_Qualifications")
    public WebElement qualifications;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    public WebElement recruitment;

    @FindBy(id = "menu_admin_registerOAuthClient")
    public WebElement registerOauthClient;

    @FindBy(id = "menu_pim_viewReportingMethods")
    public WebElement reportingMethods;

    @FindBy(id = "menu_core_viewDefinedPredefinedReports")
    public WebElement reports1;

    @FindBy(id = "menu_leave_Reports")
    public WebElement reports2;

    @FindBy(id = "menu_time_Reports")
    public WebElement reports3;

    @FindBy(id = "menu_performance_searchEvaluatePerformancReview")
    public WebElement reviewList;

    @FindBy(id = "menu_admin_viewSkills")
    public WebElement skills;

    @FindBy(id = "menu_admin_openIdProvider")
    public WebElement socialMediaAuthentication;

    @FindBy(id = "menu_admin_viewCompanyStructure")
    public WebElement structure;

    @FindBy(id = "Subscriber_link")
    public WebElement subscribe;

    @FindBy(css = "a[href='/index.php/support/index']")
    public WebElement support;

    @FindBy(id = "menu_pim_viewTerminationReasons")
    public WebElement terminationReasons;

    @FindBy(id = "menu_time_viewTimeModule")
    public WebElement time;

    @FindBy(id = "menu_time_Timesheets")
    public WebElement timesheets1;

    @FindBy(css = "#dashboard-quick-launch-panel-menu_holder table.quickLaungeContainer tbody tr td:nth-of-type(3) div.quickLaunge a")
    public WebElement timesheets2;

    @FindBy(id = "menu_performance_addPerformanceTracker")
    public WebElement trackers;

    @FindBy(id = "menu_admin_UserManagement")
    public WebElement userManagement;

    @FindBy(id = "menu_admin_viewSystemUsers")
    public WebElement users;

    @FindBy(id = "menu_recruitment_viewJobVacancy")
    public WebElement vacancies;

    @FindBy(id = "welcome")
    public WebElement welcomeManoj;

    @FindBy(id = "menu_admin_workShift")
    public WebElement workShifts;

    @FindBy(id = "menu_leave_defineWorkWeek")
    public WebElement workWeek;

    public Dashboard() {
    	PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    /**
     * Click on About Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAboutLink() {
        about.click();
        return this;
    }

    /**
     * Click on Access Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAccessRecordsLink() {
        accessRecords.click();
        return this;
    }

    /**
     * Click on Add Employee Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAddEmployeeLink() {
        addEmployee.click();
        return this;
    }

    /**
     * Click on Add Entitlements Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAddEntitlementsLink() {
        addEntitlements.click();
        return this;
    }

    /**
     * Click on Admin Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAdminLink() {
        admin.click();
        return this;
    }

    /**
     * Click on Apply Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickApplyLeaveLink() {
        applyLeave.click();
        return this;
    }

    /**
     * Click on Apply Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickApplyLink() {
        apply.click();
        return this;
    }

    /**
     * Click on Assign Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAssignLeave1Link() {
        assignLeave1.click();
        return this;
    }

    /**
     * Click on Assign Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAssignLeave2Link() {
        assignLeave2.click();
        return this;
    }

    /**
     * Click on Attendance Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAttendanceLink() {
        attendance.click();
        return this;
    }

    /**
     * Click on Attendance Summary Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickAttendanceSummaryLink() {
        attendanceSummary.click();
        return this;
    }

    /**
     * Click on Buzz Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickBuzzLink() {
        buzz.click();
        return this;
    }

    /**
     * Click on Cancel Button.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickCancelButton() {
        cancel.click();
        return this;
    }

    /**
     * Click on Candidate Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickCandidateRecordsLink() {
        candidateRecords.click();
        return this;
    }

    /**
     * Click on Candidates Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickCandidatesLink() {
        candidates.click();
        return this;
    }

    /**
     * Click on Configuration Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickConfiguration1Link() {
        configuration1.click();
        return this;
    }

    /**
     * Click on Configuration Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickConfiguration2Link() {
        configuration2.click();
        return this;
    }

    /**
     * Click on Configuration Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickConfiguration3Link() {
        configuration3.click();
        return this;
    }

    /**
     * Click on Configure Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickConfigure1Link() {
        configure1.click();
        return this;
    }

    /**
     * Click on Configure Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickConfigure2Link() {
        configure2.click();
        return this;
    }

    /**
     * Click on Custom Fields Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickCustomFieldsLink() {
        customFields.click();
        return this;
    }

    /**
     * Click on Customers Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickCustomersLink() {
        customers.click();
        return this;
    }

    /**
     * Click on Dashboard Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickDashboardLink() {
        dashboard.click();
        return this;
    }

    /**
     * Click on Data Import Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickDataImportLink() {
        dataImport.click();
        return this;
    }

    /**
     * Click on Directory Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickDirectoryLink() {
        directory.click();
        return this;
    }

    /**
     * Click on Education Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEducationLink() {
        education.click();
        return this;
    }

    /**
     * Click on Email Configuration Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmailConfigurationLink() {
        emailConfiguration.click();
        return this;
    }

    /**
     * Click on Email Subscriptions Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmailSubscriptionsLink() {
        emailSubscriptions.click();
        return this;
    }

    /**
     * Click on Employee Entitlements Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeEntitlementsLink() {
        employeeEntitlements.click();
        return this;
    }

    /**
     * Click on Employee List Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeListLink() {
        employeeList.click();
        return this;
    }

    /**
     * Click on Employee Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeRecords1Link() {
        employeeRecords1.click();
        return this;
    }

    /**
     * Click on Employee Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeRecords2Link() {
        employeeRecords2.click();
        return this;
    }

    /**
     * Click on Employee Reports Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeReportsLink() {
        employeeReports.click();
        return this;
    }

    /**
     * Click on Employee Timesheets Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeTimesheetsLink() {
        employeeTimesheets.click();
        return this;
    }

    /**
     * Click on Employee Trackers Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmployeeTrackersLink() {
        employeeTrackers.click();
        return this;
    }

    /**
     * Click on Employment Status Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEmploymentStatusLink() {
        employmentStatus.click();
        return this;
    }

    /**
     * Click on Entitlements Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickEntitlementsLink() {
        entitlements.click();
        return this;
    }

    /**
     * Click on General Information Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickGeneralInformationLink() {
        generalInformation.click();
        return this;
    }

    /**
     * Click on Holidays Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickHolidaysLink() {
        holidays.click();
        return this;
    }

    /**
     * Click on Job Categories Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickJobCategoriesLink() {
        jobCategories.click();
        return this;
    }

    /**
     * Click on Job Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickJobLink() {
        job.click();
        return this;
    }

    /**
     * Click on Job Titles Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickJobTitlesLink() {
        jobTitles.click();
        return this;
    }

    /**
     * Click on Kpis Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickKpisLink() {
        kpis.click();
        return this;
    }

    /**
     * Click on Language Packages Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLanguagePackagesLink() {
        languagePackages.click();
        return this;
    }

    /**
     * Click on Languages Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLanguagesLink() {
        languages.click();
        return this;
    }

    /**
     * Click on Leave Entitlements And Usage Report Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeaveEntitlementsAndUsageReportLink() {
        leaveEntitlementsAndUsageReport.click();
        return this;
    }

    /**
     * Click on Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeaveLink() {
        leave.click();
        return this;
    }

    /**
     * Click on Leave List Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeaveList1Link() {
        leaveList1.click();
        return this;
    }

    /**
     * Click on Leave List Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeaveList2Link() {
        leaveList2.click();
        return this;
    }

    /**
     * Click on Leave Period Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeavePeriodLink() {
        leavePeriod.click();
        return this;
    }

    /**
     * Click on Leave Types Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLeaveTypesLink() {
        leaveTypes.click();
        return this;
    }

    /**
     * Click on Licenses Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLicensesLink() {
        licenses.click();
        return this;
    }

    /**
     * Click on Localization Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLocalizationLink() {
        localization.click();
        return this;
    }

    /**
     * Click on Locations Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLocationsLink() {
        locations.click();
        return this;
    }

    /**
     * Click on Logout Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickLogoutLink() {
        logout.click();
        return this;
    }

    /**
     * Click on Maintenance Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMaintenanceLink() {
        maintenance.click();
        return this;
    }

    /**
     * Click on Manage Reviews Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickManageReviews1Link() {
        manageReviews1.click();
        return this;
    }

    /**
     * Click on Manage Reviews Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickManageReviews2Link() {
        manageReviews2.click();
        return this;
    }

    /**
     * Click on Marketplace Button.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMarketplaceButton() {
        marketplace.click();
        return this;
    }

    /**
     * Click on Memberships Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMembershipsLink() {
        memberships.click();
        return this;
    }

    /**
     * Click on Modules Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickModulesLink() {
        modules.click();
        return this;
    }

    /**
     * Click on My Entitlements Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyEntitlementsLink() {
        myEntitlements.click();
        return this;
    }

    /**
     * Click on My Info Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyInfoLink() {
        myInfo.click();
        return this;
    }

    /**
     * Click on My Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyLeave1Link() {
        myLeave1.click();
        return this;
    }

    /**
     * Click on My Leave Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyLeave2Link() {
        myLeave2.click();
        return this;
    }

    /**
     * Click on My Leave Entitlements And Usage Report Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyLeaveEntitlementsAndUsageReportLink() {
        myLeaveEntitlementsAndUsageReport.click();
        return this;
    }

    /**
     * Click on My Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyRecordsLink() {
        myRecords.click();
        return this;
    }

    /**
     * Click on My Reviews Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyReviewsLink() {
        myReviews.click();
        return this;
    }

    /**
     * Click on My Timesheet Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyTimesheetLink() {
        myTimesheet.click();
        return this;
    }

    /**
     * Click on My Timesheets Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyTimesheetsLink() {
        myTimesheets.click();
        return this;
    }

    /**
     * Click on My Trackers Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickMyTrackersLink() {
        myTrackers.click();
        return this;
    }

    /**
     * Click on Nationalities Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickNationalitiesLink() {
        nationalities.click();
        return this;
    }

    /**
     * Click on Ok Button.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickOkButton() {
        ok.click();
        return this;
    }

    /**
     * Click on Optional Fields Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickOptionalFieldsLink() {
        optionalFields.click();
        return this;
    }

    /**
     * Click on Orangehrm Inc Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickOrangehrmIncLink() {
        orangehrmInc.click();
        return this;
    }

    /**
     * Click on Orangehrm Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickOrangehrmLink() {
        orangehrm.click();
        return this;
    }

    /**
     * Click on Organization Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickOrganizationLink() {
        organization.click();
        return this;
    }

    /**
     * Click on Pay Grades Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickPayGradesLink() {
        payGrades.click();
        return this;
    }

    /**
     * Click on Performance Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickPerformanceLink() {
        performance.click();
        return this;
    }

    /**
     * Click on Pim Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickPimLink() {
        pim.click();
        return this;
    }

    /**
     * Click on Project Info Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickProjectInfoLink() {
        projectInfo.click();
        return this;
    }

    /**
     * Click on Project Reports Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickProjectReportsLink() {
        projectReports.click();
        return this;
    }

    /**
     * Click on Projects Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickProjectsLink() {
        projects.click();
        return this;
    }

    /**
     * Click on Punch Inout Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickPunchInoutLink() {
        punchInout.click();
        return this;
    }

    /**
     * Click on Purge Records Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickPurgeRecordsLink() {
        purgeRecords.click();
        return this;
    }

    /**
     * Click on Qualifications Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickQualificationsLink() {
        qualifications.click();
        return this;
    }

    /**
     * Click on Recruitment Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickRecruitmentLink() {
        recruitment.click();
        return this;
    }

    /**
     * Click on Register Oauth Client Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickRegisterOauthClientLink() {
        registerOauthClient.click();
        return this;
    }

    /**
     * Click on Reporting Methods Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickReportingMethodsLink() {
        reportingMethods.click();
        return this;
    }

    /**
     * Click on Reports Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickReports1Link() {
        reports1.click();
        return this;
    }

    /**
     * Click on Reports Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickReports2Link() {
        reports2.click();
        return this;
    }

    /**
     * Click on Reports Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickReports3Link() {
        reports3.click();
        return this;
    }

    /**
     * Click on Review List Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickReviewListLink() {
        reviewList.click();
        return this;
    }

    /**
     * Click on Skills Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickSkillsLink() {
        skills.click();
        return this;
    }

    /**
     * Click on Social Media Authentication Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickSocialMediaAuthenticationLink() {
        socialMediaAuthentication.click();
        return this;
    }

    /**
     * Click on Structure Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickStructureLink() {
        structure.click();
        return this;
    }

    /**
     * Click on Subscribe Button.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickSubscribeButton() {
        subscribe.click();
        return this;
    }

    /**
     * Click on Support Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickSupportLink() {
        support.click();
        return this;
    }

    /**
     * Click on Termination Reasons Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickTerminationReasonsLink() {
        terminationReasons.click();
        return this;
    }

    /**
     * Click on Time Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickTimeLink() {
        time.click();
        return this;
    }

    /**
     * Click on Timesheets Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickTimesheets1Link() {
        timesheets1.click();
        return this;
    }

    /**
     * Click on Timesheets Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickTimesheets2Link() {
        timesheets2.click();
        return this;
    }

    /**
     * Click on Trackers Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickTrackersLink() {
        trackers.click();
        return this;
    }

    /**
     * Click on User Management Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickUserManagementLink() {
        userManagement.click();
        return this;
    }

    /**
     * Click on Users Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickUsersLink() {
        users.click();
        return this;
    }

    /**
     * Click on Vacancies Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickVacanciesLink() {
        vacancies.click();
        return this;
    }

    /**
     * Click on Welcome Manoj Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickWelcomeManojLink() {
        welcomeManoj.click();
        return this;
    }

    /**
     * Click on Work Shifts Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickWorkShiftsLink() {
        workShifts.click();
        return this;
    }

    /**
     * Click on Work Week Link.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard clickWorkWeekLink() {
        workWeek.click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the Dashboard class instance.
     */
    public Dashboard verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
