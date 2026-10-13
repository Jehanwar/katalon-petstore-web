import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.base_url)

WebUI.click(findTestObject('page_Home/btn_Sign_in'))

WebUI.click(findTestObject('page_Sign_in/btn_Sign_up'))

WebUI.setText(findTestObject('page_Sign_up/input_UserID'), username)

WebUI.setText(findTestObject('page_Sign_up/input_Newpassword'), password)

WebUI.setText(findTestObject('page_Sign_up/input_Repeat_password'), repeat_password)

WebUI.setText(findTestObject('page_Sign_up/input_First_name'), firstname)

WebUI.setText(findTestObject('page_Sign_up/input_Last_name'), lastname)

WebUI.setText(findTestObject('page_Sign_up/input_Email'), email)

WebUI.setText(findTestObject('page_Sign_up/input_Phone'), phone)

WebUI.setText(findTestObject('page_Sign_up/input_Address_1'), address1)

if (address2) {
	WebUI.setText(findTestObject('page_Sign_up/input_Address_2'), address2)
}

WebUI.setText(findTestObject('page_Sign_up/input_City'), city)

WebUI.setText(findTestObject('page_Sign_up/input_State'), state)

WebUI.setText(findTestObject('page_Sign_up/input_Zip'), zip)

WebUI.setText(findTestObject('page_Sign_up/input_Country'), country)

WebUI.selectOptionByLabel(findTestObject('page_Sign_up/select_Language_preference'), language, false)

WebUI.selectOptionByLabel(findTestObject('page_Sign_up/select_Favourite_category'), category, false)

// Logika untuk MyList
if (enable_mylist?.toBoolean()) {
	WebUI.check(findTestObject('page_Sign_up/checkbox_Enable_mylist'))
} else {
	WebUI.uncheck(findTestObject('page_Sign_up/checkbox_Enable_mylist'))
}
// Logika untuk MyBanner
if (enable_mybanner?.toBoolean()) {
	WebUI.check(findTestObject('page_Sign_up/checkbox_Enable_mybanner'))
} else {
	WebUI.uncheck(findTestObject('page_Sign_up/checkbox_Enable_mybanner'))
}

WebUI.click(findTestObject('page_Sign_up/btn_Save_account'))

if (ExpectedResult == 'Success') {
    // SUKSES: Tombol Save Account sudah hilang (karena sudah pindah ke Catalog)
    WebUI.verifyElementNotPresent(findTestObject('page_Sign_up/btn_Save_account'), 5)
} else {
    // GAGAL: Masih ada di form registrasi (Save Account masih ada) ATAU server melempar error 500
    boolean isStillInForm = WebUI.verifyElementPresent(findTestObject('page_Sign_up/btn_Save_account'), 3, FailureHandling.OPTIONAL)
    boolean isError500 = WebUI.verifyTextPresent('HTTP Status 500', false, FailureHandling.OPTIONAL)

    // Dinyatakan PASSED jika salah satu dari kondisi gagal di atas terpenuhi
    WebUI.verifyEqual(isStillInForm || isError500, true)
}

WebUI.closeBrowser()

