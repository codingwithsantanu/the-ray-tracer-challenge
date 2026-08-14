def fuzzy_equals(a: float, b: float, epsilon: float = 1e-4) -> bool:
    return abs(a - b) < epsilon