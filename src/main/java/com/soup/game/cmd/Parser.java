package com.soup.game.cmd;

import com.soup.game.intf.Command;

import java.util.ArrayList;
import java.util.List;
/**
 * <h1>Command Parser</h1>
 * The {@code Parser} class handles the lexical analysis of the F+ command language.
 * <p>
 * This class is responsible for breaking down raw command input into tokens that
 * can be processed by the command executor. It handles quoted strings as single
 * tokens and manages whitespace separation according to F+ language specifications.
 * </p>
 *
 * <h2>F+ Tokenization Rules</h2>
 * <ul>
 *     <li>Tokens are separated by whitespace (spaces, tabs, newlines)</li>
 *     <li>Double quotes ({@code "}) group multiple words into a single token</li>
 *     <li>Quoted tokens are returned without the quote characters</li>
 *     <li>Empty tokens are discarded</li>
 * </ul>
 *
 * <h2>Usage Example</h2>
 * <pre>{@code
 * Parser parser = new Parser();
 * String[] tokens = parser.tokenize("plant 1 2 \"hello world\"");
 * // Result: ["plant", "1", "2", "hello world"]
 * }</pre>
 *
 * @see Executor
 * @author isGoodSoup
 * @version 1.0
 * @since 1.9
 */
public class Parser implements Command {
    
    /**
     * Tokenizes a command line string into arguments, preserving quoted segments.
     * <p>
     * Splits the input on whitespace, except when inside double quotes. Quoted
     * substrings are treated as a single token and returned without the quote characters.
     * </p>
     *
     * <p>
     * Example:
     * </p>
     * <pre>
     * input:  plant 1 "hello world"
     * output: ["plant", "1", "hello world"]
     * </pre>
     *
     * @param commandLine the raw command line input
     * @return an array of tokens representing the parsed arguments
     */
    public String[] tokenize(String commandLine) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuote = false;

        for(int i = 0; i < commandLine.length(); i++) {
            char c = commandLine.charAt(i);
            if(c == '"') {
                inQuote = !inQuote;
                continue;
            }
            if(Character.isWhitespace(c) && !inQuote) {
                if(!current.isEmpty()) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if(!current.isEmpty()) tokens.add(current.toString());
        return tokens.toArray(new String[0]);
    }
}
