package com.soup.game.cmd;

import com.soup.game.intf.Command;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/**
 * <h1>Command Registry</h1>
 * The {@code Registry} class serves as the central storage system for all F+ commands
 * and runtime variables in the game.
 * <p>
 * This class maintains two separate collections:
 * <ul>
 *     <li>A command map that associates command names with their executable handlers</li>
 *     <li>A variable map that stores runtime values accessible during script execution</li>
 * </ul>
 * </p>
 *
 * <h2>Command Registration</h2>
 * <p>
 * Commands are registered with a lowercase name for case-insensitive lookup. Each command
 * is associated with a {@link Consumer} that accepts a String array containing the
 * command name followed by its arguments.
 * </p>
 *
 * <h2>Variable Management</h2>
 * <p>
 * Variables in F+ can store any Object type and are globally accessible throughout
 * script execution. They can be set, retrieved, checked for existence, and removed
 * during runtime. The registry maintains a static variable map, meaning variables
 * persist across different registry instances.
 * </p>
 *
 * <h2>Thread Safety</h2>
 * <p>
 * The registry uses {@link LinkedHashMap} to maintain insertion order for both
 * commands and variables, providing predictable iteration behavior. The variable
 * map is static, allowing shared variable state across the entire game.
 * </p>
 *
 * <h2>Usage Example</h2>
 * <pre>{@code
 * Registry registry = new Registry();
 *
 * // Register a command
 * registry.register("plant", args -> plant(args));
 *
 * // Set and retrieve variables
 * registry.setVariable("water", 100f);
 * Object water = registry.getVariable("water");
 *
 * // Check command existence
 * if(registry.hasCommand("harvest")) {
 *     Consumer<String[]> handler = registry.get("harvest");
 * }
 * }</pre>
 *
 * @see Executor
 * @author isGoodSoup
 * @version 1.0
 * @since 1.9
 */
public class Registry implements Command {
    private final Map<String, Consumer<String[]>> commands = new LinkedHashMap<>();
    private static final Map<String, Object> variables = new LinkedHashMap<>();

    /**
     * Registers a new command with the registry.
     * <p>
     * The command name is automatically converted to lowercase to ensure
     * case-insensitive command matching during execution. If a command with
     * the same name already exists, it will be overwritten.
     * </p>
     * @param name the name of the command (case-insensitive)
     * @param handler the {@link Consumer} that executes the command logic
     */
    public void register(String name, Consumer<String[]> handler) {
        commands.put(name.toLowerCase(), handler);
    }

    /**
     * Retrieves a command handler by its name.
     * <p>
     * The lookup is case-insensitive. Returns {@code null} if no command
     * with the given name exists.
     * </p>
     * @param name the name of the command to retrieve
     * @return the command handler, or {@code null} if not found
     */
    public Consumer<String[]> get(String name) {
        return commands.get(name.toLowerCase());
    }

    /**
     * Checks if a command exists in the registry.
     * @param name the name of the command to check
     * @return {@code true} if the command exists, {@code false} otherwise
     */
    public boolean hasCommand(String name) {
        return commands.containsKey(name.toLowerCase());
    }

    /**
     * Returns a set of all registered command names.
     * <p>
     * The returned set reflects the current state of the registry and
     * maintains insertion order.
     * </p>
     * @return an immutable view of the command names
     */
    public Set<String> getCommandNames() {
        return commands.keySet();
    }

    /**
     * Sets a variable in the global variable store.
     * <p>
     * Variables are stored statically and persist across registry instances.
     * If a variable with the same name already exists, its value is overwritten.
     * </p>
     * @param name the name of the variable
     * @param value the value to store (can be any Object type)
     */
    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    /**
     * Retrieves a variable from the global variable store.
     * @param name the name of the variable to retrieve
     * @return the variable value, or {@code null} if not found
     */
    public Object getVariable(String name) {
        return variables.get(name);
    }

    /**
     * Retrieves a variable with a default fallback value.
     * <p>
     * If the variable doesn't exist, returns the specified default value
     * instead of {@code null}.
     * </p>
     * @param name the name of the variable to retrieve
     * @param defaultValue the value to return if the variable doesn't exist
     * @return the variable value, or {@code defaultValue} if not found
     */
    public Object getVariableOrDefault(String name, Object defaultValue) {
        return variables.getOrDefault(name, defaultValue);
    }

    /**
     * Checks if a variable exists in the global store.
     * @param name the name of the variable to check
     * @return {@code true} if the variable exists, {@code false} otherwise
     */
    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

    /**
     * Removes a variable from the global store.
     * <p>
     * If the variable doesn't exist, this method does nothing.
     * </p>
     * @param name the name of the variable to remove
     */
    public void removeVariable(String name) {
        variables.remove(name);
    }

    /**
     * Clears all variables from the global store.
     * <p>
     * This method removes every variable currently stored in the registry,
     * resetting the variable state to empty.
     * </p>
     */
    public void clear() {
        variables.clear();
    }

    /**
     * Returns a set of all variable names in the global store.
     * <p>
     * The returned set maintains insertion order and reflects the current
     * state of the variable store.
     * </p>
     * @return a set of all variable names
     */
    public Set<String> getVariableNames() {
        return variables.keySet();
    }
}