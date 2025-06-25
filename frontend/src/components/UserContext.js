import React, { createContext, useState } from 'react'
export const UserContext=createContext()
export default function UserProvider({children}) {
  const[userdetails,setUserdetails]=useState(null)
  return (
    <UserContext.Provider value={{userdetails,setUserdetails}}>
      {children}
    </UserContext.Provider>
  )
}
