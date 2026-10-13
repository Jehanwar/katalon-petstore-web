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

// 1. Buka browser dan buka web JPetStore
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.base_url)
// 2. Klik tombol Sign In di halaman Home
WebUI.click(findTestObject('page_Home/btn_Sign_in'))
// 3. Masukkan username & password dari Global Variable (Tanpa Hardcode)
WebUI.setText(findTestObject('page_Sign_in/input_Username'), GlobalVariable.valid_username)
WebUI.setText(findTestObject('page_Sign_in/input_Password'), GlobalVariable.valid_password)
// 4. Klik tombol Login
WebUI.click(findTestObject('page_Sign_in/btn_Login'))
// 5. Assertion: Verifikasi berhasil login dengan memastikan tombol 'Sign Out' muncul di layar
WebUI.verifyElementPresent(findTestObject('page_Home/btn_Sign_out'), 5)
// 6. Tutup browser
WebUI.closeBrowser()