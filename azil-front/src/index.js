import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, HashRouter as Router, Routes, Navigate, NavLink } from 'react-router-dom';
import { Navbar, Nav, Button, Container} from 'react-bootstrap';
import Home from './components/Home';
import NotFound from './components/NotFound';
import Ljubimci from'./components/ljubimci/Ljubimci';
import Login from './components/authorization/Login';
import {logout} from './services/Auth';
import AddLjubimac from './components/ljubimci/AddLjubimac';

const App = () => {


    const jwt = window.localStorage.getItem("jwt")

   if(jwt){
        return (
        <>
            <Router>
                <Navbar expand bg="secondary" variant="light">
                    <Navbar.Brand as={Link} to="/">
                    PetAdopt
                    </Navbar.Brand>
                    <Nav>
                    <Button variant="light" onClick={()=>logout()}>Logout</Button>
                    </Nav>
                    <Nav.Link  as={Link} to="/ljubimci">
                    LJUBIMCI
                    </Nav.Link>
                
             
                </Navbar> 
                <Container style={{paddingTop:"25px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Navigate replace to='/'/>} />
                    <Route path="/ljubimci" element={<Ljubimci/>}/>
                    <Route path="/ljubimci/add" element={<AddLjubimac/>} />
                    
                    <Route path="*" element={<NotFound/>} />
                </Routes>
            </Container>
            </Router>
        </>
    );
    }else{
        return( 
        <>
            <Router>
            <Navbar expand bg="light" variant="light">
                    <Navbar.Brand as={Link} to="/">
                    PetAdopt
                    </Navbar.Brand>
                    <Nav>
                   
                    <Nav.Link as={Link} to="/login">
                        Login
                    </Nav.Link>
        
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Login/>}/>
                    <Route path="*" element={<Navigate replace to = "/login"/>}/>
                </Routes>
                </Container>
            </Router>
       </>);
    }
 }

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App/>,
)