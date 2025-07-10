package com.StepDefinition;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsForm;

public class ContactUsSteps extends BaseClass {
    ContactUsForm contactus;
@Then("Verify Contact Us is visible")
public void verify_contact_us_is_visible() {
   contactus = new  ContactUsForm(driver);
    contactus.contactUsVisible();
}
@When("Click on Contact Us button")
public void click_on_contact_us_button() {
  contactus.contactUsClick();
}
@Then("enter name in contact us form {string}")
public void enter_enter_name(String name) {
 contactus.enterName(name);
}
@Then("enter email in contact us form {string}")
public void enter_email(String email) {
  contactus.enterEmail(email);
}
@Then("enter subject in contact us form {string}")
public void enter_subject(String subject) {
    contactus.enterSubject(subject);
}
@Then("enter message in contact us form {string}")
public void enter_message(String message) {
   contactus.enterMessage(message);
}
@Then("Click Submit button")
public void click_submit_button() {
   contactus.clickSubmit();
}
@When("Click OK button")
public void click_ok_button() {
   contactus.okAlert();
}
@Then("Verify success message is visible")
public void verify_success_message_is_visible() {
contactus.sucessMessageVisible();
}
}
