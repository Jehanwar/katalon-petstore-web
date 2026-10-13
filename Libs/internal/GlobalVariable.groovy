package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : web demo</p>
     */
    public static Object base_url
     
    /**
     * <p></p>
     */
    public static Object valid_username
     
    /**
     * <p></p>
     */
    public static Object valid_password
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
    
            base_url = selectedVariables['base_url']
            valid_username = selectedVariables['valid_username']
            valid_password = selectedVariables['valid_password']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
