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

// 2. Klik kategori Ikan (Fish)
WebUI.click(findTestObject('page_Home/link_Category_Fish'))

// 3. Pilih produk Angelfish
WebUI.click(findTestObject('page_Home/link_Product_Angelfish'))

// 4. Klik tombol Add to Cart
WebUI.click(findTestObject('page_Home/btn_Add_to_cart'))

// 5. Assertion: Verifikasi halaman Shopping Cart muncul dengan item yang dipilih
WebUI.verifyTextPresent('Shopping Cart', false)

WebUI.verifyTextPresent('EST-1', false)

// 6. Tutup browser
WebUI.closeBrowser()