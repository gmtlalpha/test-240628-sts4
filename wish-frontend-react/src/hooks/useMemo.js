import { useMemo } from "react";

/**
 * useMemo
 * only runs when one of its dependencies update.
 * useMemo and useCallback Hooks are similar.
 * The main difference is that useMemo returns a memoized value
 * and useCallback returns a memoized function
 */
const calculation = expensiveCalculation(count);
const calculation = useMemo(() => expensiveCalculation(count), [count]);
