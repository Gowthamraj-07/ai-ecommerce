import logo from './logo.svg';
import './App.css';
import HomePage from './components/home/HomePage';
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import LoginPage from './components/Login/LoginPage';
import Navbar from './components/Navbar';
import RegisterPage from './components/Register/RegisterPage';
import UserProvider, { UserContext } from './components/UserContext';
function App() {
  return (
    <div className="App">
      <UserProvider>
      <BrowserRouter>
      <Navbar/>
          <Routes>
              <Route path='/' element={<HomePage/>}/>
              <Route path='/login' element={<LoginPage/>}/>
              <Route path='/register' element={<RegisterPage/>}/>
          </Routes>
      </BrowserRouter>
      </UserProvider>
        
    </div>
  );
}

export default App;
