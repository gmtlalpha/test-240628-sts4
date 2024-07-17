import { createContext, useState } from "react";

/**
 * useContext
 * manage state globally.
 */
const UserContext = createContext();
const [user, setUser] = useState('Jesse Hall');
const user = useContext(UserContext);
