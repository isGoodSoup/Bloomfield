package com.soup.game.service;

import com.soup.game.intf.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Handles localization and translation for the game.
 *
 * <p>Provides methods to retrieve localized messages from resource bundles
 * and format them with parameters. Supports changing the current locale
 * at runtime.</p>
 */
@Service
public class Localization {
    public static Localization lang = new Localization(Locale.forLanguageTag("en"));
    private ResourceBundle bundle;
    private Locale locale;

    /**
     * Creates a Localization instance with the specified locale.
     * @param locale the {@link Locale} to use for translations
     */
    public Localization(Locale locale) {
        setLocale(locale);
    }

    /**
     * Sets the current locale and reloads the resource bundle.
     *
     * @param locale the new {@link Locale} to use
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
        String baseFile = "i18n/lang";
        bundle = ResourceBundle.getBundle(baseFile, locale);
    }

    /**
     * Retrieves a translated string for the given key.
     * <p>If the key does not exist in the resource bundle, the key itself
     * is returned as a fallback.</p>
     * @param key the translation key
     * @return the localized string or the key if missing
     */
    public String t(String key) {
        try {
            return bundle.getString(key);
        } catch(Exception e) {
            return key;
        }
    }

    /**
     * Retrieves a translated string for the given key and formats it
     * with provided arguments.
     * <p>If the key does not exist in the resource bundle, the key itself
     * is returned as a fallback.</p>
     * @param key  the translation key
     * @param args optional arguments for formatting
     * @return the formatted localized string or the key if missing
     */
    public String t(String key, Object... args) {
        try {
            return MessageFormat.format(bundle.getString(key), args);
        } catch(Exception e) {
            return key;
        }
    }

    /**
     * Returns the current locale used for translations.
     * @return the current {@link Locale}
     */
    public Locale getLocale() {
        return locale;
    }
}