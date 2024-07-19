import { useState } from "react";


const UseState = () => {

    const [car, setCar] = useState({
        brand: 'Ford',
        model: 'Mustang',
        year: '1964',
        color: 'red',
    });

    const updateColor = () => {
        setCar((previousState) => {
            return { ...previousState, color: 'blue' };
        });
    };
    return (
        <>
        <h2>color:{car.color}</h2>
        <button onClick={updateColor}>update-Color</button>
        </>
    )

}

export { UseState };