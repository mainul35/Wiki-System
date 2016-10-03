/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wiki.DataModel.StoreData;

/**
 *
 * @author Mainul35
 */
public class VersionInformation {
    private int versionNumber;
    private String userRole;
    private String username;
    private String pageTitle;
    private String URI;

    /**
     * @return the versionNumber
     */
    public int getVersionNumber() {
        return versionNumber;
    }

    /**
     * @param versionNumber the versionNumber to set
     */
    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pageTitle
     */
    public String getPageTitle() {
        return pageTitle;
    }

    /**
     * @param pageTitle the pageTitle to set
     */
    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    /**
     * @return the URI
     */
    public String getURI() {
        return URI;
    }

    /**
     * @param URI the URI to set
     */
    public void setURI(String URI) {
        this.URI = URI;
    }
}
