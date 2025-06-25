import React, { useContext, useState } from 'react'
import Navbar from '../Navbar';
import './LoginPage.css'
import { Link } from 'react-router-dom';
import UserProvider, { UserContext } from '../UserContext';
export default function () {
    const {setUserdetails}=useContext(UserContext)
    const[email,setEmail]=useState();
    const[password,setPassword]=useState();
    const handleLogin=async(e)=>{
        e.preventDefault();
        const user={email,password};
        try{
            const res=await fetch("http://localhost:7777/login",{
                method:'POST',
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(user),
            })
            const data=await res.json()
            if(!data||!data.id)
            {
                alert("Invalid Email or password!");
                return;
            }
            localStorage.setItem("user",JSON.stringify(user))
            setUserdetails(data)
            alert("Login Succesful")
            console.log(data)
            
        }
        catch(err)
        {
            alert("Error occured")
            return;
        }

    }
  return (
      <div className='loginpage'>
        <div className='formcontainer'>
        <form onSubmit={handleLogin}>
            <input className='fields' type='text' placeholder='Email' value={email} onChange={(e)=>{setEmail(e.target.value)}}></input><br />
            <input className='fields' type="text" placeholder='Password' value={password} onChange={(e)=>{setPassword(e.target.value)}} /><br/>
            <button type='submit'>Login</button>
        </form>
        <p>New User? <Link to='/register'>Register Now!</Link></p>
        </div>
    </div>
  )
}
