package org.darkware.hero.base;

/**
 * @author jeff
 * @since 2015-08-15
 */
public class Portion
{
    private int current;
    private int max;

    /**
     * Creates a new Portion with the given current and max values.
     *
     * @param current The current value of the portion.
     * @param max The maximum value.
     */
    public Portion(int current, int max)
    {
        super();

        this.current = current;
        this.max = max;
    }

    /**
     * Creates a new Portion with the defined max and maximum portion.
     *
     * @param max The maximum value.
     */
    public Portion(int max)
    {
        this(max, max);
    }

    /**
     * Fetches the current portion value.
     *
     * @return The current value.
     */
    public int getCurrent()
    {
        return this.current;
    }

    /**
     * Fetches the maximum allowed value.
     *
     * @return The maximum value.
     */
    public int getMax()
    {
        return this.getMax();
    }

    /**
     * Fetches the fractional value of the Portion. This represents the percentage
     * of the maximum that the current value represents.
     *
     * @return The fractional value as a <code>double</code> between 0.0 and 1.0, inclusive.
     */
    public double getFraction()
    {
        return (double)this.current / (double)this.max;
    }

    /**
     * Fetches the difference between the current value and the maximum.
     *
     * @return The difference, as a value between 0 and the current maximum.
     */
    public int getMissing()
    {
        return this.max - this.current;
    }

    /**
     * Adjusts the current value by the given integer delta. The final value will be
     * clamped to 0 and the maximum value.
     *
     * @param delta The delta, as a positive or negative integer.
     */
    public void adjust(int delta)
    {
        if (delta >= this.current)
        {
            this.zero();
        }
        else
        {
            this.current += delta;
            this.normalize();
        }
    }

    /**
     * Adjusts the current value by a multiplicative factor. The final value will be
     * clamped to 0 and the maximum value. Any fractional values are rounded up.
     *
     * @param factor A factor
     * @throws IllegalArgumentException If the factor is less than zero.
     */
    public void adjustFactor(double factor)
    {
        if (factor == 0.00) this.zero();
        else if (factor < 0.0D) throw new IllegalArgumentException("Portion adjustment factors cannot be negative.");
        else
        {
            final int delta = (int) Math.ceil(factor * (double) this.current) - this.current;

            this.adjust(delta);
        }
    }

    /**
     * Adjusts the maximum value. If proportional increases are requested, then the current
     * value is increased by a proportional amount, retaining the same fractional value.
     * Otherwise, the value is unchanged, resulting in a lower fractional value.
     *
     * @param delta The amount of change to apply to the maximum.
     * @param proportional Whether the current value should be adjusted a proportional amount.
     */
    public void adjustMax(int delta, boolean proportional)
    {
        if (proportional)
        {
            final double frac = this.getFraction();
            this.current = (int)Math.ceil(frac * (max + delta));
        }
        this.max += delta;

        this.normalize();
    }

    /**
     * Adjusts the current value, raising it a fraction of the missing amount.
     *
     * @param factor The fractional amount of the missing portion to add.
     * @see #getMissing()
     * @throws IllegalArgumentException If the factor is less than zero, or greater than 1.
     */
    public void fillRemaining(double factor)
    {
        if (factor < 0.0D) throw new IllegalArgumentException("Portion fill fraction cannot be negative.");
        if (factor > 1.0D) throw new IllegalArgumentException("Portion fill fraction cannot be more than 1.0.");

        this.current += this.getMissing() * factor;
    }

    /**
     * Forces the current value to be set to zero.
     */
    public void zero()
    {
        this.current = 0;
    }

    /**
     * Adjusts the value to the nearest valid value.
     */
    protected void normalize()
    {
        if (this.current < 1) this.zero();
        else this.current = Math.min(this.current, this.max);
    }
}
