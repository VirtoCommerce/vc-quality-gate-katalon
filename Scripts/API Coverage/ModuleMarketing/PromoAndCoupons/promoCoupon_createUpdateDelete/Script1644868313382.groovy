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
import groovy.json.JsonSlurper

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject


'Create a promotion first'
promoCreate = WS.callTestCase(findTestCase('API Coverage/ModuleMarketing/PromoAndCoupons/promoCreate'),
	null)


'Add coupon to the promotion'
int maxUsesNumber = 15
int maxUsesPerUses = 10
couponName = GlobalVariable.promoName + 'Coupon'
couponAdd = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponAdd',[
	('promoId') : GlobalVariable.promoId,
	('couponName') : couponName,
	('maxUsesNumber') : maxUsesNumber,
	('maxUsesPerUser') : maxUsesPerUses
	]))


'Search for the created coupon to verify creation and and get the id'
couponSearch = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponSearch', [
	('code') : couponName
	]))
WS.containsString(couponSearch, couponName, false)
WS.verifyElementPropertyValue(couponSearch,'results[0].maxUsesNumber',maxUsesNumber)
WS.verifyElementPropertyValue(couponSearch,'results[0].maxUsesPerUser',maxUsesPerUses)
WS.verifyElementPropertyValue(couponSearch,'results[0].code',couponName)
GlobalVariable.couponId = WS.getElementPropertyValue(couponSearch,'results[0].id')
println GlobalVariable.couponId


'Update the created coupon'
couponNameUpdated = couponName + 'UPD'
maxUsesNumberUpdated  = maxUsesNumber + 2
maxUsesPerUserUpdated  = maxUsesPerUses + 2
couponUpdate = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponUpdate',[
	('promoId') : GlobalVariable.promoId,
	('couponId') : GlobalVariable.couponId,
	('couponName') : couponNameUpdated ,
	('maxUsesNumber') : maxUsesNumberUpdated ,
	('maxUsesPerUser') : maxUsesPerUserUpdated 
	]))


'Get the created coupon data (by id)'
couponGet = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponGet',[
	('couponId') : GlobalVariable.couponId
	]))
WS.verifyElementPropertyValue(couponGet,'code', couponNameUpdated)
WS.verifyElementPropertyValue(couponGet,'maxUsesNumber', maxUsesNumberUpdated)
WS.verifyElementPropertyValue(couponGet,'maxUsesPerUser', maxUsesPerUserUpdated)


'Delete the created coupon'
couponDelete = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponDelete',[
	('couponId') : GlobalVariable.couponId
	]))


'Verify the coupon has been deleted'
verifyDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoCouponSearch'))
WS.verifyElementPropertyValue(verifyDeleted,'results','[]') 
GlobalVariable.couponId = WS.getElementPropertyValue(couponSearch,'results[0].id')


'Delete the promotion from the first step'
deletePromo = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoDelete', [
	('promoId') : GlobalVariable.promoId
	]))


'VERIFY THE PROMO HAS BEEN DELETED'
verifyDeleted = WS.sendRequestAndVerify(findTestObject('API/backWebServices/VirtoCommerce.Marketing/Promotions/PromoSearch',[
	('keyword') : GlobalVariable.firstName
	]))
WS.verifyElementPropertyValue(verifyDeleted,'totalCount', '0')
