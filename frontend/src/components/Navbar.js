import React, { useContext } from 'react'
import "./Navbar.css"
import { Link } from 'react-router-dom'
import { UserContext } from './UserContext'
export default function Navbar() {
  const {userdetails}=useContext(UserContext);
  return (
    <nav className='navbar'>
        <Link to='/'><div className='logo'>Ai-E Commerce</div></Link>
        <ul className='nav-links'>
            <li>Products</li>
            {userdetails?<li>{userdetails.username}</li>:<li><Link to="/login">Login</Link></li>}
        </ul>
    </nav>
  )
}
