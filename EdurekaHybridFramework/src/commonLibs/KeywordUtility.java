package commonLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordUtility {

	CommonDriver oDriver;

	public KeywordUtility() {
		oDriver = new CommonDriver();
	}

	public String performAction(String sActionName, By oBy, String sValue) {

		String returnValue = "";

		try {

			if (sActionName.isEmpty()) {

			} else {

				switch (sActionName.trim().toLowerCase()) {

				case "click":
					oDriver.clickElement(oBy);
					returnValue = "";
					break;

				case "openbrowser":
					oDriver.openBrowser(sValue, "about:blank");
					returnValue = "";
					break;

				case "setpageloadtimeOut":
					oDriver.setPageLoadTimeOut(Long.valueOf(sValue));
					returnValue = "";
					break;

				case "setlementdetectiontimeout":
					oDriver.setElementDetectionTimeOut(Long.valueOf(sValue));
					returnValue = "";
					break;

				case "threadsleep":
					try {
						Thread.sleep(Long.parseLong(sValue));
					} catch (InterruptedException e) {
						e.printStackTrace();
						return e.getMessage();
					}
					returnValue = "";
					break;

				case "navigatetourl":
					oDriver.getUrl(sValue);
					returnValue = "";
					break;

				case "navigateback":
					oDriver.getDriver().navigate().back();
					returnValue = "";
					break;

				case "navigateforward":
					oDriver.getDriver().navigate().forward();
					returnValue = "";
					break;

				case "closeallbrowsers":
					oDriver.closeAllBrowsers();
					returnValue = "";
					break;

				case "closecurrentbrowser":
					oDriver.closeCurrentBrowser();
					returnValue = "";
					break;

				case "waittillelementisvisible":
					oDriver.waitTillElementIsVisible(oBy, Long.valueOf(sValue));
					returnValue = "";
					break;

				case "waittillelementisclickable":
					oDriver.waitTillElementIsVisible(oBy, Long.valueOf(sValue));
					returnValue = "";
					break;

				case "savepagesnapshot":
					String returnvalue = oDriver.savePageSnapshot(sValue);
					returnValue = returnvalue;
					break;

				case "submit":
					oDriver.getDriver().findElement(oBy).submit();
					returnValue = "";
					break;

				case "clear":
					oDriver.getDriver().findElement(oBy).clear();
					returnValue = "";
					break;

				case "selectparentwindow":
					oDriver.selectParentWindow();
					returnValue = "";
					break;

				case "acceptalert":
					oDriver.getDriver().switchTo().alert().accept();
					returnValue = "";
					break;

				case "rejectalert":
					oDriver.getDriver().switchTo().alert().dismiss();
					returnValue = "";
					break;

				case "selectdefaultframe":
					oDriver.getDriver().switchTo().defaultContent();
					returnValue = "";
					break;

				case "switchtoframe":
					oDriver.switchToFrame(sValue);
					returnValue = "";
					break;

				case "gettext":
					returnValue = oDriver.getText(oBy);
					break;

				case "gettextboxtext":
					if (oDriver.getDriver().findElement(oBy).getAttribute("value").equals(sValue)) {
						returnValue = "pass";
					} else {
						returnValue = "error";
					}
					break;

				case "verifytext":
					returnValue = oDriver.verifyText(oBy, sValue);
					break;

				case "gettitle":
					returnValue = oDriver.getDriver().getTitle();
					break;

				case "verifytitle":
					if (oDriver.getDriver().getTitle().equals(sValue)) {
						returnValue = "pass";
					} else {
						returnValue = "Verifaction Failed";
					}
					break;

				case "geturl":
					returnValue = oDriver.getDriver().getCurrentUrl();
					break;

				case "verifyurl":
					if (oDriver.getDriver().getCurrentUrl().equals(sValue)) {
						returnValue = "pass";
					} else {
						returnValue = "Verification Failed";
					}
					break;

				case "settext":
					oDriver.setText(oBy, sValue);
					returnValue = "";
					break;

				case "getstatus":
					returnValue = String.valueOf(oDriver.getDriver().findElement(oBy).isSelected());
					break;

				case "getselecteditem":
					Select olist;
					WebElement oElement;
					oElement = oDriver.getDriver().findElement(oBy);
					olist = new Select(oElement);
					returnValue = olist.getFirstSelectedOption().getText();
					break;

				case "selectitembytext":
					oDriver.selectItemInListBox(oBy, sValue);
					returnValue = "";
					break;

				case "selectitembyvalue":
					oDriver.selectItemByValueInListBox(oBy, sValue);
					returnValue = "";
					break;

				case "getitemscount":
					Select olist1;
					WebElement oElement1;
					oElement1 = oDriver.getDriver().findElement(oBy);
					olist1 = new Select(oElement1);
					returnValue = String.valueOf(olist1.getOptions().size());
					break;

				case "isdisplayed":
					if (oDriver.getDriver().findElement(oBy).isDisplayed()) {
						returnValue = "Element is present";
					} else {
						returnValue = "Element is not present";
					}
					returnValue = "";
					break;

				case "mousehover":
					returnValue = oDriver.mouseHover(oBy);
					break;

				case "mousehoverandclick":
					returnValue = oDriver.mouseHoverAndClick(oBy);
					break;

				case "isenabled":
					oDriver.getDriver().findElement(oBy).isEnabled();
					returnValue = "";
					break;

				case "switchtowindow":
					oDriver.switchToWindow(Integer.parseInt(sValue));
					returnValue = "";
					break;

				case "presstab":
					oDriver.pressTab(sValue);
					returnValue = "";
					break;

				case "scrolltoelement":
					oDriver.scrollToElement(oBy);
					returnValue = "";
					break;

				case "scrolltotop":
					oDriver.scrollToTop();
					returnValue = "";
					break;

				case "scrolltobottom":
					oDriver.scrollToBottom();
					returnValue = "";
					break;

				case "iterateelementsandclick":
					System.out.println("Inside Keyword Utility to find Elements");
					oDriver.iterateElementsAndClick(oBy);
					returnValue = "";
					break;

				default:
					throw new Exception("Error: Unknown keyword..");

				}

			}

		} catch (Throwable t) {

			t.printStackTrace();

		}

		return returnValue;
	}
}
