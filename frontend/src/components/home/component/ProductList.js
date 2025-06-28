import React, { useEffect, useState } from 'react'
import "./ProductList.css"
export default function ProductList() {
    const[products,setProducts]=useState([])
    const url="http://localhost:7777/getall"
    useEffect(()=>{
        fetch(url).then(response=>response.json()).then(data=>setProducts(data))
    },[])
    const handleCart=async(product)=>{
      const user=JSON.parse(localStorage.getItem('user'));
      if(user==null)
      {
        alert("Login to add to cart!");
        return;
      }
      const res=await fetch("http://localhost:7777/addcart",
        {
          method:'POST',
          headers:{"Content-Type":"application/json"},
          body:JSON.stringify({
            userId:user.id,
            productId:product.id,
            quantity:1
          })
        }
      )
      const msg=await res.text();
      console.log(msg);
      

    }
  return (
    <div className='gridcontainer'>
        {products.map(product=>(
            <div className='item' key={product.id}>
               <img src='https://paragonfootwear.com/cdn/shop/products/k1015g_blk_1.jpg?v=1741864787&width=2000'/>
                <h4>{product.name}</h4>
                <h4>{product.brand}</h4>
                <button onClick={()=>handleCart(product)}>Add to cart</button>
            </div>
        ))}
    </div>
  )
}
