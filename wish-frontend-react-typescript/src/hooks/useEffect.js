import { useEffect, useState } from "react";

const UseEffect = () =>{
    
    /**
     * useEffect(<function>, <dependency>)
     * side effects in your components. fetching data, directly updating the DOM, and timers.
     */
    const [count, setCount] = useState(0);
    useEffect(() => {
      setTimeout(() => {
        setCount((count) => count + 1);
      }, 1000);
    //}); //Runs on every render
    // }, []); //Runs only on the first render
    }, [count]); //Runs on the first render And any time any dependency value changes

}

export {UseEffect}