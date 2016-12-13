/*
 * Class: JCCommonExceptionHandler
 *
 * Comments for Developers Only:
 *
 * Version History:
 * 
 * Ver  Date         Who                Release     What and Why
 * ---  ----------   ----------         -------     ---------------------------------------
 * 1.0  03/11/2009   ElayaRaja S		 1.0		JCException Framework
 * 
 * This software is the confidential and proprietary information of Jamcracker, Inc. 
 * ("Confidential Information").  You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you 
 *  entered into with Jamcracker, Inc. Copyright (c) 2000 Jamcracker, Inc.  All Rights    
 *  Reserved
 *
 *
 * 
 ******************************************************/

package com.sanworks.common.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

/**
 * A class used for JCCommonExceptionHandler
 * 
 */
public class CommonExceptionHandler {

	private static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(CommonExceptionHandler.class.getName());

	private static String errorProperitesHome = null;	

	/**
	 * This object contains all the errors of global scope.
	 */
	private static HashMap globalErrorsMap;

	/**
	 * This object contains all the errors of marketplace level scope.
	 */
	private static HashMap customErrorsMap;

	private static final String defaultLocaleString = "en";

	private static boolean loadedProperties = false;

	private static final String MODULES_LIST_FILE_NAME = "errorpropertyfileslist_<<LOCALE>>.properties";

	private static final String ERROR_PROPERTIES_FILE_NAME = "Errors_<<LOCALE>>.properties";

	/**
	 * Returns error message for a given error code from loaded properties
	 * files. Returns blank message if the errorcode is not found.
	 * 
	 * @param errorKey
	 *            error code for which error messages to be found.
	 * @return error message
	 */
	public static String getErrorMessage(String errorKey) {
		return getErrorMessage(errorKey, Locale.ENGLISH);
	}

	/**
	 * @param errorKey
	 *            as String
	 * @param currentLocale
	 *            as java.util.Locale
	 * @return ErrorMessage as String
	 */
	public static String getErrorMessage(String errorKey, java.util.Locale currentLocale) {
		return getErrorMessage(errorKey, null, currentLocale);
	}

	/**
	 * Returns error message for a given error code from loaded properties
	 * files. Returns blank message if the errorcode is not found.
	 * 
	 * @param errorKey
	 * @param marketplaceAcronym
	 * @param locale
	 * @return
	 */
	public static String getErrorMessage(String errorKey, String marketplaceAcronym, Locale locale) {

		if (LOG.isDebugEnabled()){
			LOG.debug("getErrorMessage() : Start");
		}			

		if (!loadedProperties) {
			initProperties();
		}

		String errorMessage = null;
		boolean foundErrorMessage = false;
		Properties properties = null;
		String localeString = null;

		if (locale != null) {
			localeString = locale.getLanguage();
		} else {
			localeString = defaultLocaleString;
		}

		// First searches in custom error map , if key is not present then
		// search in global error map
		if (marketplaceAcronym != null && customErrorsMap != null
				&& customErrorsMap.get(marketplaceAcronym) != null) {
			properties = (Properties) customErrorsMap.get(marketplaceAcronym);

			if (properties != null && properties.getProperty(errorKey) != null) {
				errorMessage = properties.getProperty(errorKey);
				foundErrorMessage = true;
			}
		}

		if (!foundErrorMessage) {
			if (globalErrorsMap != null && globalErrorsMap.get(localeString) != null) {
				properties = (Properties) globalErrorsMap.get(localeString);

				if (properties != null && properties.getProperty(errorKey) != null) {
					errorMessage = properties.getProperty(errorKey);
					foundErrorMessage = true;
				} else {
					// If no error message found, set message as empty string
					if (LOG.isDebugEnabled()){
						LOG.debug("No error message found. Getting from default locale : en_US");
					}						

					if (globalErrorsMap != null && globalErrorsMap.get(defaultLocaleString) != null) {
						properties = (Properties) globalErrorsMap.get(defaultLocaleString);

						if (properties != null&& properties.getProperty(errorKey) != null) {
							errorMessage = properties.getProperty(errorKey);
							foundErrorMessage = true;
						}
					}
				}
			}
		}

		if (errorMessage == null) {
			errorMessage = " ";
		}
		
		if (LOG.isDebugEnabled()){
			LOG.debug("getErrorMessage() : End");
		}
		
		return errorMessage;
	}

	/**
	 * Initializes all the error properties
	 */
	private static void initProperties() {
		
		if (LOG.isDebugEnabled()){
			LOG.debug("Initializing error properties ... ");
		}
		
		globalErrorsMap = new HashMap();
		customErrorsMap = new HashMap();

		String modulesFile = MODULES_LIST_FILE_NAME.replaceFirst("<<LOCALE>>",
				defaultLocaleString);
		loadGlobalModules(modulesFile, defaultLocaleString);
		/* loadCustomModules(); */

		loadedProperties = true;
		
		if (LOG.isDebugEnabled()){
			LOG.debug("Initializing error properties ... done");
		}
			
	}

	/**
	 * This method loads all the error properties in the global scope
	 * 
	 * @param modulesFile
	 * @param localeString
	 */
	private static void loadGlobalModules(String modulesFile, String localeString) {

		if (LOG.isDebugEnabled()){
			LOG.debug("loadGlobalModules() : Start");
		}			

		String readLine = null;
		FileInputStream fileInputStream = null;
		String errorProperitesHome = getErrorPropertiesHome();
		File file = new File(errorProperitesHome + "/" + modulesFile);
		Properties properties = new Properties();

		// Reads the Errors_<<LOCALE>> property file
		String errorsFile = ERROR_PROPERTIES_FILE_NAME.replaceFirst("<<LOCALE>>", localeString);
		loadPropertiesFromFile(errorProperitesHome + "/" + errorsFile, properties);

		if (file.exists()) {
			try {
				fileInputStream = new FileInputStream(file);
				BufferedReader bReader = new BufferedReader(new InputStreamReader(fileInputStream));

				while ((readLine = bReader.readLine()) != null) {
					readLine = readLine.trim();

					// Ignoring comments
					if (readLine.startsWith("#") || "".equalsIgnoreCase(readLine)) {
						continue;
					}
					loadPropertiesFromFile(errorProperitesHome + "/" + readLine, properties);
				}
			} catch (IOException ioe) {
				LOG.error("Cannot read from " + modulesFile + " : ", ioe);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException ioe) {
					LOG.error("Error in closing " + readLine + " : ", ioe);
				}
			}
		}
		globalErrorsMap.put(localeString, properties);
		
		if (LOG.isDebugEnabled()){
			LOG.debug("loadGlobalModules() : End");
		}
			
	}

	/**
	 * @param errorFileName
	 *            as String
	 * @param properties
	 *            as Properties
	 */
	private static void loadPropertiesFromFile(String errorFileName, Properties properties) {

		if (LOG.isDebugEnabled()){
			LOG.debug("loadPropertiesFromFile() : Start");
		}
		
		FileInputStream fileInputStream = null;

		File file = new File(errorFileName);
		if (file.exists() && !file.isDirectory()) {
			try {
				fileInputStream = new FileInputStream(file);
				properties.load(fileInputStream);
			} catch (IOException ioe) {
				LOG.error("Cannot load file : " + errorFileName + " : ", ioe);
			} finally {
				try {
					fileInputStream.close();
				} catch (IOException ioe) {
					LOG.error("Error in closing " + errorFileName + " : ", ioe);
				}
			}
		}
		if (LOG.isDebugEnabled()){
			LOG.debug("loadPropertiesFromFile() : End");
		}
			
	}

	/**
	 * @param errorKey
	 * @return DetailedErrorMessage as String
	 */
	public static String getDetailedErrorMessage(String errorKey) {
		return getDetailedErrorMessage(errorKey, Locale.ENGLISH);
	}

	/**
	 * @param errorKey
	 *            as String
	 * @param currentLocale
	 *            as java.util.Locale
	 * @return DetailedErrorMessage as String
	 */
	public static String getDetailedErrorMessage(String errorKey,java.util.Locale currentLocale) {
		
		if (LOG.isDebugEnabled()){
			LOG.debug("getDetailedErrorMessage message for currentLocale "+ errorKey);
		}

		String message = getErrorMessage(errorKey, currentLocale);
		StringBuffer msgBuffer = new StringBuffer();
		String corrActionKey = errorKey + ".CA";
		String corrAction = null;

		if (message != null) {

			msgBuffer.append(errorKey).append(" ");
			String type = getErrorType(errorKey);

			if (type != null) {
				msgBuffer.append(type).append(" error. ");
			}

			msgBuffer.append(message + " ");
		
			// TODO
			corrAction = getCorrectiveAction(corrActionKey, null,currentLocale); 
			if (corrAction != null)
			msgBuffer.append(corrAction);
			 
		}
		return msgBuffer.toString();
	}
	
	 /**
	  * This method gets the corrective action related to an error code
	  * @param correctiveActionKey
	  * @param locale
	  * @param marketplaceAcronym
	  * @return Corrective Action. If not found or empty, returns null
	  */
	 public static String getCorrectiveAction(String correctiveActionKey, String marketplaceAcronym, Locale locale) {
		 
		if (LOG.isDebugEnabled()){
			LOG.debug("getCorrectiveAction() : Start");
		}
	 	
	 	String correctiveAction = null;
	 	String correctiveActionPointer = null;
	 	Properties properties = null;
	 	String localeString = null;
	 	
	 	if (locale != null) {
	 		localeString= locale.getLanguage();
	 	} else {
	 		localeString = defaultLocaleString;
	 	}

	 	properties = (Properties) globalErrorsMap.get(localeString);
	 	
	 	if (properties != null && properties.getProperty(correctiveActionKey) != null) {
	 		correctiveActionPointer = properties.getProperty(correctiveActionKey);
	 		
	 		if (correctiveActionPointer != null) {
	 			correctiveAction = getErrorMessage(correctiveActionPointer, marketplaceAcronym, locale);
	 		}
	 	}
	 	
	 	if (" ".equals(correctiveAction)) {
	 		correctiveAction = null;
	 	}
	 	
	 	if (LOG.isDebugEnabled()){
	 		LOG.debug ("Corrective action :" + correctiveAction);	 	
	 	    LOG.debug("getCorrectiveAction() : End");	 		
	 	}
	 	
	 	return correctiveAction;
	 }

	/**
	 * @param errorKey
	 *            as String
	 * @return ErrorType as String
	 */
	public static String getErrorType(String errorKey) {
		return getErrorType(errorKey, Locale.ENGLISH);
	}

	/**
	 * @param errorKey
	 * @param currentLocale
	 * @return ErrorType as String
	 */
	public static String getErrorType(String errorKey, java.util.Locale currentLocale) {
		String typeCode = "Type." + errorKey.substring(0, 2);
		
		if (LOG.isDebugEnabled()){
			LOG.debug("TypeCode: " + typeCode);
		}

		String type = null;
		type = getErrorMessage(typeCode, currentLocale);

		if (LOG.isDebugEnabled()){
			LOG.debug("Type: " + type);
		}

		return type;
	}
	
	/**
	 * @param corrActionKey
	 * @return String
	 */
	private static String getCorrectiveAction(String corrActionKey) {
		return getCorrectiveAction(corrActionKey, null, Locale.ENGLISH);
	}
	
	/**
	 * Added for Globalization
	 * @param corrActionKey
	 * @param errorsProps
	 * @return String
	 */
	private static String getCorrectiveAction(String corrActionKey, Properties errorsProps) {

		String corrAction = null;
		String corrActionPointer = null;

		if (errorsProps.containsKey(corrActionKey))
			corrActionPointer = (String) errorsProps.get(corrActionKey);
		if (corrActionPointer != null)
			corrAction = (String) errorsProps.get(corrActionPointer);

		return corrAction;
	}
	 

	/**
	 * @return ErrorPropertiesHome as String
	 */
	public static String getErrorPropertiesHome() /* throws Exception */{
		if (errorProperitesHome != null) {
			return errorProperitesHome;
		} else {
			try {
				String configHome = System.getProperty("PP_CONFIG_HOME");
				File currentPath = new File (configHome);
				if (LOG.isDebugEnabled()){
					LOG.debug("errorProperitesHome: "+currentPath.getAbsolutePath());
				}
				
				errorProperitesHome = currentPath.getAbsolutePath();				
				 
			} catch (Exception ex) {
				LOG.error("Error in checking the ERROR_PROPERTIES_HOME: ", ex);
			}
		}

		return errorProperitesHome;
	}

}
