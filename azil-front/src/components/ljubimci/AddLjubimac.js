import { useEffect } from "react";
import { useCallback } from "react";
import { useState } from "react";
import Axios from "../../apis/Axios";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const AddLjubimac=()=>{
    let ljubimac={

        ime:"",
       brojMeseci:0,
       pol:"",
       tezina:0.0 ,
        opis:"",
        kategorija:null
       }
       const [noviLjubimac,setNoviLjubimac]=useState(ljubimac);
      const [kategorije, setKategorije]=useState([]);
       var navigate = useNavigate()

      
       const getKategorije = useCallback(() => {
        Axios.get('/kategorije')
            .then(res => {
                 console.log(res);
                 setKategorije(res.data)
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            });
    }, [])
	
    useEffect(() => {
        getKategorije()
    }, [])


       const oneSelectionChanged=(e)=>{
        const value = e.target.value
        setNoviLjubimac({...noviLjubimac,ime:value})
        
       }

       const twoSelectionChanged=(e)=>{
        const value = e.target.value
        setNoviLjubimac({...noviLjubimac,brojMeseci:value})
        
       }

       const threeSelectionChanged=(e)=>{
        const value = e.target.value
        setNoviLjubimac({...noviLjubimac,pol:value})
        
       }
      

       const forSelectionChanged=(e)=>{
        const value = e.target.value
        setNoviLjubimac({...noviLjubimac,tezina:value})
        
       }

       const fiveSelectionChanged=(e)=>{
        const value = e.target.value
        setNoviLjubimac({...noviLjubimac,opis:value})
        
        }
      
       const sixSelectionChanged=(e)=>{
        const value = e.target.value

        let ljubimciFromState = noviLjubimac

        ljubimciFromState.kategorija = value
        setNoviLjubimac(ljubimciFromState)


        }

       const create=()=>{
         let ljubimacDTO = {
         'ime': noviLjubimac.ime,
         'brojMeseci':noviLjubimac.brojMeseci,
         'pol':noviLjubimac.pol,
         'tezina':noviLjubimac.tezina,
         'opis':noviLjubimac.opis,
         'kategorijaId': noviLjubimac.kategorija
      }
          

           Axios.post("/ljubimci", ljubimacDTO).then(res=>{

            alert("Uspesano dodavanje");
            navigate("/ljubimci");
           }).catch(err=>{

            alert( "error");
           })

          }

    return(
        <>
         <Row>
        <Col></Col>
     <Col sm="8">
      <Form>
        <Form.Group>
      <Form.Label htmFor="a">Ime</Form.Label>
      <Form.Control id="a" type="text" placeholder="Lajka"
       onChange={(e)=>oneSelectionChanged(e) }></Form.Control>
       </Form.Group>

       <Form.Group>
      <Form.Label htmFor="b">Starost u mesecima</Form.Label>
      <Form.Control id="b" type="text" placeholder="12"
      onChange={(e)=>twoSelectionChanged(e) }>
      </Form.Control>
      </Form.Group>

      <Form.Group>
      <Form.Label htmFor="c">Pol</Form.Label>
      <Form.Select id="c" type="text"
      onChange={(e)=>threeSelectionChanged(e) }>
      <option value="">Izaberite pol</option>
      <option value="muski">Muški</option>
      <option value="zenski">Ženski</option>
      </Form.Select>
      </Form.Group>

      <Form.Group>
      <Form.Label htmFor="f">Tezina</Form.Label>
      <Form.Control id="f" type="text" placeholder="8.9"
      onChange={(e)=>forSelectionChanged(e) }>
      </Form.Control>
      </Form.Group>

      <Form.Group>
      <Form.Label htmFor="p">Opis</Form.Label>
      <Form.Control id="p" type="text" placeholder="Prvi pas poslat u Zemljinu orbitu"
       onChange={(e)=>fiveSelectionChanged(e) }>
      </Form.Control>
      </Form.Group>

        <Form.Group className="mb-3">
                <Form.Label htmlFor="s">Kategorija</Form.Label>
                <Form.Select name="s"  onChange={(e) => sixSelectionChanged(e)}>
                <option value="">Izaberite kategoriju</option>
                {
                 kategorije.map(kategorija => {
                return (
                    <option value={kategorija.id} key={kategorija.id}>{kategorija.naziv}</option>
                        )
                    })
                }
                 </Form.Select>
                 </Form.Group>
                
    <Button variant="outline-success" onClick={() => create()}>Add</Button>
      </Form>
      </Col>
</Row>
        </>
    )
}

export default AddLjubimac