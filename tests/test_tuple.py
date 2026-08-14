from src.tuple import Tuple4

def test_creation() -> None:
    tuple = Tuple4(1.2, 2.3, 3.4, 4.5)
    assert tuple.x == 1.2
    assert tuple.y == 2.3
    assert tuple.z == 3.4
    assert tuple.w == 4.5
