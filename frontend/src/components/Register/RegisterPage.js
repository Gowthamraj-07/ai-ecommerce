import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'


export default function RegisterPage() {
    const navigate=useNavigate();
    const[username,setUsername]=useState()
    const[email,setEmail]=useState()
    const[password,setPassword]=useState()
    const handleSubmit=async(e)=>{
        e.preventDefault();
        const user={username,email,password}
        try{
            const res=await fetch("http://localhost:7777/postuser",{
                method:'POST',
                headers:{'Content-Type':'application/json'},
                body:JSON.stringify(user),
            })
            const data=await res.json();
            if(!data||!data.id)
            {
                alert("Email Already Exists!")
                return
            }
            alert("Registration Success! Login Now");
            navigate('/Login')
        }
        catch(err)
        {
            alert("Error occured!")
        }
    }
  return (
    <div className='loginpage'>
        <div className='formcontainer'>
        <form onSubmit={handleSubmit}>
            <input className='fields' type="text" value={username} name="username" placeholder='Username' onChange={(e)=>{setUsername(e.target.value)}} /><br/>
            <input className='fields'type="text" value={email} name="email" placeholder='Email' onChange={(e)=>{setEmail(e.target.value)}} /><br/>
            <input className='fields' type="text" value={password} name="password" placeholder='Password' onChange={(e)=>{setPassword(e.target.value)}} /><br/>
            <button type='submit'>Register</button>
        </form>
        </div>
    </div>
  )
}
