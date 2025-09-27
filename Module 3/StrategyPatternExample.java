/*
This file aggregates example code from the Strategy pattern in the java-design-patterns repository.
Source: https://github.com/iluwatar/java-design-patterns/tree/master/strategy
License: MIT (license headers from original files retained below)
Note: This single file has been adapted to compile standalone: package declarations and Lombok have been removed, and logging uses System.out.println.
*/

// ----- DragonSlayingStrategy.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** Strategy interface. */
@FunctionalInterface
interface DragonSlayingStrategy {

  void execute();
}

// ----- MeleeStrategy.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** Melee strategy. */
class MeleeStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    System.out.println("With your Excalibur you sever the dragon's head!");
  }
}

// ----- ProjectileStrategy.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** Projectile strategy. */
class ProjectileStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    System.out.println("You shoot the dragon with the magical crossbow and it falls dead on the ground!");
  }
}

// ----- SpellStrategy.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** Spell strategy. */
class SpellStrategy implements DragonSlayingStrategy {

  @Override
  public void execute() {
    System.out.println("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!");
  }
}

// ----- DragonSlayer.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** DragonSlayer uses different strategies to slay the dragon. */
class DragonSlayer {

  private DragonSlayingStrategy strategy;

  public DragonSlayer(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void changeStrategy(DragonSlayingStrategy strategy) {
    this.strategy = strategy;
  }

  public void goToBattle() {
    strategy.execute();
  }
}

// ----- LambdaStrategy.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/** Lambda implementation for enum strategy pattern. */
class LambdaStrategy {

  /** Enum to demonstrate strategy pattern. */
  public enum Strategy implements DragonSlayingStrategy {
  MELEE_STRATEGY(() -> System.out.println("With your Excalibur you sever the dragon's head!")),
  PROJECTILE_STRATEGY(
    () ->
      System.out.println(
        "You shoot the dragon with the magical crossbow and it falls dead on the ground!")),
  SPELL_STRATEGY(
    () ->
      System.out.println(
        "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"));

    private final DragonSlayingStrategy dragonSlayingStrategy;

    Strategy(DragonSlayingStrategy dragonSlayingStrategy) {
      this.dragonSlayingStrategy = dragonSlayingStrategy;
    }

    @Override
    public void execute() {
      dragonSlayingStrategy.execute();
    }
  }
}

// ----- App.java -----
/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * The Strategy pattern (also known as the policy pattern) is a software design pattern that enables
 * an algorithm's behavior to be selected at runtime.
 *
 * <p>Before Java 8 the Strategies needed to be separate classes forcing the developer to write lots
 * of boilerplate code. With modern Java, it is easy to pass behavior with method references and
 * lambdas making the code shorter and more readable.
 *
 * <p>In this example ({@link DragonSlayingStrategy}) encapsulates an algorithm. The containing
 * object ({@link DragonSlayer}) can alter its behavior by changing its strategy.
 */
public class StrategyPatternExample {

  private static final String RED_DRAGON_EMERGES = "Red dragon emerges.";
  private static final String GREEN_DRAGON_SPOTTED = "Green dragon spotted ahead!";
  private static final String BLACK_DRAGON_LANDS = "Black dragon lands before you.";

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {
    // GoF Strategy pattern
  System.out.println(GREEN_DRAGON_SPOTTED);
  DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
    dragonSlayer.goToBattle();
  System.out.println(RED_DRAGON_EMERGES);
    dragonSlayer.changeStrategy(new ProjectileStrategy());
    dragonSlayer.goToBattle();
  System.out.println(BLACK_DRAGON_LANDS);
    dragonSlayer.changeStrategy(new SpellStrategy());
    dragonSlayer.goToBattle();

    // Java 8 functional implementation Strategy pattern
  System.out.println(GREEN_DRAGON_SPOTTED);
  dragonSlayer = new DragonSlayer(() -> System.out.println("With your Excalibur you sever the dragon's head!"));
    dragonSlayer.goToBattle();
  System.out.println(RED_DRAGON_EMERGES);
  dragonSlayer.changeStrategy(
    () ->
      System.out.println(
        "You shoot the dragon with the magical crossbow and it falls dead on the ground!"));
    dragonSlayer.goToBattle();
  System.out.println(BLACK_DRAGON_LANDS);
  dragonSlayer.changeStrategy(
    () ->
      System.out.println(
        "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"));
    dragonSlayer.goToBattle();

    // Java 8 lambda implementation with enum Strategy pattern
  System.out.println(GREEN_DRAGON_SPOTTED);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.MELEE_STRATEGY);
    dragonSlayer.goToBattle();
  System.out.println(RED_DRAGON_EMERGES);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.PROJECTILE_STRATEGY);
    dragonSlayer.goToBattle();
  System.out.println(BLACK_DRAGON_LANDS);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.SPELL_STRATEGY);
    dragonSlayer.goToBattle();
  }
}
