package main;

import main.tuples.Vector;
import main.tuples.Point;

public class Main {
    static Projectile projectile;
    static Environment environment;

    public static void main(String[] args) {
        projectile = new Projectile(
            new Point(0.0, 1.0, 0.0),
            new Vector(1.0, 1.0, 1.0).normalize()
        );
        environment = new Environment(
            new Vector(0.0, -0.1, 0.0),
            new Vector(-0.01, 0.0, 0)
        );

        final int numberOfTicks = 20;
        for (int i = 0; i < numberOfTicks; i++) {
            tick();
            System.out.println(projectile.position);
        }

        /* SAMPLE OUTPUT:
         | Point{x=0.5773502691896258, y=1.5773502691896257, z=0.5773502691896258}
         | Point{x=1.1447005383792517, y=2.054700538379252, z=1.1547005383792517}
         | Point{x=1.7020508075688774, y=2.432050807568878, z=1.7320508075688776}
         | Point{x=2.2494010767585033, y=2.7094010767585037, z=2.3094010767585034}
         | Point{x=2.786751345948129, y=2.8867513459481295, z=2.886751345948129}
         | Point{x=3.314101615137755, y=2.9641016151377553, z=3.464101615137755}
         | Point{x=3.8314518843273806, y=2.9414518843273814, z=4.041451884327381}
         | Point{x=4.3388021535170065, y=2.8188021535170074, z=4.618802153517007}
         | Point{x=4.836152422706633, y=2.5961524227066333, z=5.196152422706633}
         | Point{x=5.323502691896258, y=2.273502691896259, z=5.773502691896259}
         | Point{x=5.800852961085884, y=1.8508529610858848, z=6.350852961085885}
         | Point{x=6.2682032302755095, y=1.3282032302755107, z=6.928203230275511}
         | Point{x=6.725553499465136, y=0.7055534994651366, z=7.505553499465138}
         | Point{x=7.172903768654761, y=-0.017096231345237523, z=8.082903768654763}
         | Point{x=7.610254037844387, y=-0.8397459621556116, z=8.660254037844389}
         | Point{x=8.037604307034012, y=-1.7623956929659856, z=9.237604307034015}
         | Point{x=8.454954576223638, y=-2.78504542377636, z=9.814954576223641}
         | Point{x=8.862304845413265, y=-3.907695154586734, z=10.392304845413268}
         | Point{x=9.259655114602891, y=-5.1303448853971085, z=10.969655114602894}
         | Point{x=9.647005383792516, y=-6.452994616207483, z=11.54700538379252}
         */
    }

    private static void tick() {
        projectile.position = projectile.position.add(projectile.velocity).toPoint();
        projectile.velocity = projectile.velocity
            .add(environment.gravity)
            .add(environment.wind)
            .toVector();
    }
}

class Environment {
    final Vector gravity;
    final Vector wind;

    Environment(Vector gravity, Vector wind) {
        this.gravity = gravity;
        this.wind = wind;
    }
}

class Projectile {
    Point position;
    Vector velocity;

    Projectile(Point position, Vector velocity) {
        this.position = position;
        this.velocity = velocity;
    }
}