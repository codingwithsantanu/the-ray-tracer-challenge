from src.tuple import Tuple4

def test_creation():
    tuple = Tuple4(1.2, 2.3, 3.4, 4.5)
    assert tuple.x == 1.2
    assert tuple.y == 2.3
    assert tuple.z == 3.4
    assert tuple.w == 4.5

def test_is_vector():
    assert not Tuple4(1, 2, 3, 4).is_vector()
    assert Tuple4(1, 2, 3, 0).is_vector()

def test_is_point():
    assert not Tuple4(1, 2, 3, 4).is_point()
    assert Tuple4(1, 2, 3, 1).is_point()
