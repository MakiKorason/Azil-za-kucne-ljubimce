import { useCallback, useEffect, useState } from "react";
import Axios from "../../apis/Axios";
import { Button, ButtonGroup, Col, Collapse, Form, FormGroup, FormLabel, Row, Table } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";

const Ljubimci=()=>{


  const [search, setSearch] = useState({ pol: "", kategorijaId: -1, opis:""})
  const [ljubimci, setLjubimci] = useState([])
  const [kategorije, setKategorije] = useState([])
  const [totalPages, setTotalPages] = useState(1)
  const [pageNo, setPageNo] = useState(0)
  const  navigate = useNavigate()
 
  const routeParams = useParams();

  const getData = () => {
    getKategorije(0);
    getLjubimci(0);

  }

  useEffect(()=>{
    getData();
  }, [])


  const getLjubimci = (page) =>  {
    let config = { params: {
        pageNo: page
      } };
      if (search.pol != "") {
        config.params.pol = search.pol;
      }
  
      if (search.kategorijaId != -1) {
        config.params.kategorijaId = search.kategorijaId;
      }
      if (search.opis != "") {
        config.params.opis = search.opis;
      }
  

      Axios.get("/ljubimci", config )

          .then((result) => {
            console.log(result)
            setPageNo(page)
            setLjubimci(result.data)
            setTotalPages(result.headers['total-pages'])
                      
          })
          .catch(error => {
              console.log("Nije uspelo dobavljanje");
            
          });
  }

 const getKategorije = () => {
Axios.get("/kategorije")
  .then((result) => {
      setKategorije(result.data)
  })
  .catch((err=>{console.log("Nije uspelo dobavljanje")}))
}


const goToAdd=()=>{
navigate("/ljubimci/add");
 } 

 const deleteLjubimac= (ljubimacId) => {
    Axios.delete('/ljubimci/' + ljubimacId)
    .then(res => {
        console.log(res);
        alert(' deleted successfully!');
        window.location.reload();
    })
    .catch(error => {
        console.log(error);
        alert('Nije vam dostupno brisanje ljubimca');
     });
}


const searchValueInputChange = (event) => {
    let newSearch = {...search}

    const name = event.target.name;
    const value = event.target.value;

    newSearch[name] = value
    setSearch(newSearch); 
    
  }

  const doSearch = () => {
    getLjubimci(0);
  }


  const goToUdomi=(ljubimacId)=>{
    Axios.post("/udomljavanje/" + ljubimacId )
    .then((res)=>{
      console.log(res);
      alert("Uspesno ste udomili vakcinisanog psa")
      window.location.reload();
    })

    .catch(()=>{
      alert("Nije uspelo udomljavanje zato sto je pas vec udomljen")
    })
  }
  const updateVakcinacija = (e, ljubimacId) => {
    const newLjubimci = ljubimci.map((ljubimac) =>
      ljubimac.id === ljubimacId ? { ...ljubimac, vakcinisan: e.target.checked } : ljubimac
    );
    setLjubimci(newLjubimci);
  };

    return(
<>
  
<h1>Ljubimci</h1>

    
    <Col sm="8">
   <Form style={{ width: "99%" }}>
    <Form.Group>
          <Form.Label >POL </Form.Label>
          <Form.Select 
            value={search.pol}
            name="pol"
            as="input"
           
            onChange={(e) => searchValueInputChange(e)}>
           <option value="">Izaberite pol</option>
           <option value="muski">Muški</option>
          <option value="zenski">Ženski</option> </Form.Select>
        </Form.Group>
        <Form.Group>
          <Form.Label>Kategorija</Form.Label>
          <Form.Select
            onChange={(event) => searchValueInputChange(event)}
            name="kategorijaId"
            value={search.kategorijaId}
            as="select"
          >
            <option value="">Izaberite kategoriju</option>
            {kategorije.map((kategorija) => {
              return (
                <option value={kategorija.id} key={kategorija.id}>
                  {kategorija.naziv}
                </option>
              );
            })}
          </Form.Select>
        </Form.Group> 
        <Form.Group>
          <Form.Label>OPIS</Form.Label>
          <Form.Control
            value={search.opis}
            name="opis"
            as="input"
           placeholder="Pitomi vučjak, tamnih očiju" onChange={(e) => searchValueInputChange(e)}
          ></Form.Control>
        </Form.Group>
        
         <Button onClick={() => doSearch()}>Search</Button>
</Form>
</Col>

<br/>
<Button variant="outline-success"  onClick={() => goToAdd()}>Add</Button>

        
<Table bordered striped style={{ marginTop: 5 }} >
                  <thead>
                      <tr>
                          <th>Ime</th>
                          <th>Starost(broj meseci)</th> 
                          <th>Vakcinisan</th>   
                          <th>Pol</th>
                          <th>Tezina</th>
                          <th>Opis</th>
                        <th>Kategorija</th>
                        <th colSpan={2}>Actions</th>
                      </tr>
                  </thead>
                  <tbody>
                      {ljubimci.map((ljubimac) => {
                          return (
                              <tr key={ljubimac.id}>
                                  <td>{ljubimac.ime}</td>
                                  <td>{ljubimac.brojMeseci}</td>
                                  <td>
                               {window.localStorage["role"] === "ROLE_ADMIN" ? (
                                   <input
                                   type="checkbox"
                                 checked={ljubimac.vakcinisan}
                                 onChange={(e)=>updateVakcinacija(e, ljubimac.id )}
                                    />
                                     ) : (
                                 ljubimac.vakcinisan === true ? "Vakcinisan" : "Nije vakcinisan")}
                                        </td>  
                                 
                                  <td>{ljubimac.pol}</td> 
                                  <td>{ljubimac.tezina}</td>
                                  <td>{ljubimac.opis}</td>
                                  <td>{ljubimac.kategorijaNaziv}</td>
                            
                                  {window.localStorage['role']==="ROLE_ADMIN" ?
                                  <td> <Button variant="danger" 
                                className="button button-navy" onClick={() => 
                                deleteLjubimac(ljubimac.id)}>Delete</Button>
                                </td>:null}
                             {window.localStorage['role']==="ROLE_KORISNIK" ?
                             <td> { ljubimac.vakcinisan && (<Button variant="warning"
                              onClick={()=>goToUdomi(ljubimac.id)} 
                             >Udomi</Button>)}</td>:null}
                              </tr>  
                          )
                      })}
                  </tbody>
              </Table>
             
              <ButtonGroup style={{ marginTop:0, float:"right"}}>
        <Button 
          style={{ margin: 3, width: 90}}
          disabled={pageNo==0} onClick={()=>getLjubimci(pageNo-1)}>
          Previous
        </Button>
        <Button
          style={{ margin: 3, width: 90}}
          disabled={pageNo==totalPages-1} onClick={()=>getLjubimci(pageNo+1)}>
          Next
        </Button>
      </ButtonGroup>
         </>
)

}
export default Ljubimci;