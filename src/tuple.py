from dataclasses import dataclass

from .utils import fuzzy_equals

@dataclass
class Tuple4:
    x: float
    y: float
    z: float
    w: float

    def is_vector(self) -> bool:
        return fuzzy_equals(self.w, 0.0)

    def is_point(self) -> bool:
        return fuzzy_equals(self.w, 1.0)

    def is_vector_or_point(self) -> bool:
        return self.is_vector() or self.is_point()