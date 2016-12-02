package org.redhat.service.impl;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.redhat.service.DictionaryService;

public class Activator implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("Language", "English");
        context.registerService(
            DictionaryService.class.getName(), new DictionaryImpl(), props);
		
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}
	private static class DictionaryImpl implements DictionaryService
    {
        // The set of words contained in the dictionary.
        String[] m_dictionary =
            { "welcome", "to", "the", "osgi", "tutorial" };

        /**
         * Implements DictionaryService.checkWord(). Determines
         * if the passed in word is contained in the dictionary.
         * @param word the word to be checked.
         * @return true if the word is in the dictionary,
         *         false otherwise.
        **/
        public boolean checkWord(String word)
        {
            word = word.toLowerCase();

            // This is very inefficient
            for (int i = 0; i < m_dictionary.length; i++)
            {
                if (m_dictionary[i].equals(word))
                {
                    return true;
                }
            }
            return false;
        }
    }

}
