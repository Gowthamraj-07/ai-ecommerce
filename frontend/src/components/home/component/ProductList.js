import React, { useEffect, useState } from 'react'
import "./ProductList.css"
export default function ProductList() {
    const[products,setProducts]=useState([])
    const url="http://localhost:7777/getall"
    useEffect(()=>{
        fetch(url).then(response=>response.json()).then(data=>setProducts(data))
    },[])
  return (
    <div className='gridcontainer'>
        {products.map(product=>(
            <div className='item' key={product.id}>
               <img src='https://paragonfootwear.com/cdn/shop/products/k1015g_blk_1.jpg?v=1741864787&width=2000'/>
                <h4>{product.name}</h4>
                <h4>{product.brand}</h4>
            </div>
        ))}
    </div>
  )
}
