package bean;

/**
 * Created by NKumar on 1/12/2017.
 */

import com.sun.security.auth.callback.TextCallbackHandler;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class JassTest {
    public static void main(String[] args) {

        // Obtain a LoginContext, needed for authentication. Tell
        // it to use the LoginModule implementation specified by
        // the entry named "JaasSample" in the JAAS login
        // configuration file and to also use the specified
        // CallbackHandler.
        System.setProperty("java.security.auth.login.config", JassTest.class.getResource("/jaas.conf").toExternalForm());
        System.setProperty("java.security.krb5.realm", "INTERNAL.IMSGLOBAL.COM");
        System.setProperty("java.security.krb5.kdc", "plysdom117.internal.imsglobal.com");
        LoginContext lc = null;
        try {
            lc = new LoginContext("JaasSample",
                    new TextCallbackHandler());
            lc.login();
            System.out.println(lc.getSubject());
        } catch (LoginException le) {
            System.err.println("Cannot create LoginContext. "
                    + le.getMessage());
            System.exit(-1);
        } catch (SecurityException se) {
            System.err.println("Cannot create LoginContext. "
                    + se.getMessage());
            System.exit(-1);
        }

        try {

            // attempt authentication
            System.out.println("==============================================");
            lc.login();

        } catch (LoginException le) {

            System.err.println("Authentication failed: ");
            System.err.println("  " + le.getMessage());
            System.exit(-1);

        }

        System.out.println("Authentication succeeded!");

    }
}
