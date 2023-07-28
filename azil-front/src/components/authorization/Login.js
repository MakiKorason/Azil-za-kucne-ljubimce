import { useState } from "react"
import { Row, Col, Form, Button } from "react-bootstrap"
import {login} from "../../services/Auth"

const Login = () => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    return(
        <Row className="justify-content-center">
            <Col md={6}>
            <Form>
                <Form.Group>
                <Form.Label>Username</Form.Label>
                <Form.Control type="text" onChange={(e)=>setUsername(e.target.value)}></Form.Control>
                </Form.Group>
                <Form.Group>
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" onChange={(e)=>setPassword(e.target.value)}></Form.Control>
                </Form.Group>
            </Form>
            <Button onClick={(e)=>login(username, password)}>Login</Button>
            </Col>
        </Row>
    )
}

export default Login