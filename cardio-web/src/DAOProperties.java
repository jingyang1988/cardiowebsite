import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class immediately loads the DAO properties file 'dao.properties' once in memory and provides
 * a constructor which takes the specific key which is to be used as property key prefix of the DAO
 * properties file. There is a property getter which only returns the property prefixed with
 * 'specificKey.' and provides the option to indicate whether the property is mandatory or not.
 *
 * @author BalusC
 * @link http://balusc.blogspot.com/2008/07/dao-tutorial-data-layer.html
 */
public class DAOProperties {

    // Constants ----------------------------------------------------------------------------------

    public static String getDriver() {
		return driver;
	}

	public static void setDriver(String driver) {
		DAOProperties.driver = driver;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		DAOProperties.url = url;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		DAOProperties.username = username;
	}

	public static String getPasswd() {
		return passwd;
	}

	public static void setPasswd(String passwd) {
		DAOProperties.passwd = passwd;
	}

	private static final String PROPERTIES_FILE = "Dao.properties";
    private static final Properties PROPERTIES = new Properties();
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String passwd = null;
    

    
    // Vars ---------------------------------------------------------------------------------------

    private String specificKey;

    // Constructors -------------------------------------------------------------------------------

    /**
     * Construct a DAOProperties instance for the given specific key which is to be used as property
     * key prefix of the DAO properties file.
     * @param specificKey The specific key which is to be used as property key prefix.
     * @throws DAOConfigurationException During class initialization if the DAO properties file is
     * missing in the classpath or cannot be loaded.
     */
    public DAOProperties(String specificKey) throws DAOConfigurationException {
   
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

            if (propertiesFile == null) {
                throw new DAOConfigurationException(
                    "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
            }

            try {
                PROPERTIES.load(propertiesFile);
                url = PROPERTIES.getProperty("jdbc.url");
                driver = PROPERTIES.getProperty("jdbc.driver");
                username = PROPERTIES.getProperty("jdbc.username");
                passwd = PROPERTIES.getProperty("jdbc.password");
                
                
            } catch (IOException e) {
                throw new DAOConfigurationException(
                    "Cannot load properties file '" + PROPERTIES_FILE + "'.", e);
            }
        

        this.specificKey = specificKey;
    }

    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the DAOProperties instance specific property value associated with the given key with
     * the option to indicate whether the property is mandatory or not.
     * @param key The key to be associated with a DAOProperties instance specific value.
     * @param mandatory Sets whether the returned property value should not be null nor empty.
     * @return The DAOProperties instance specific property value associated with the given key.
     * @throws DAOConfigurationException If the returned property value is null or empty while
     * it is mandatory.
     */
    public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new DAOConfigurationException("Required property '" + fullKey + "'"
                    + " is missing in properties file '" + PROPERTIES_FILE + "'.");
            } else {
                // Make empty value null. Empty Strings are evil.
                property = null;
            }
        }

        return property;
    }

}