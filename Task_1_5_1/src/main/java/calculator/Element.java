package calculator;

/**
 * Element of list-result of parsing.
 *
 * @param flag - if true => it's function, else => number.
 */
public record Element(boolean flag, double num) { }
