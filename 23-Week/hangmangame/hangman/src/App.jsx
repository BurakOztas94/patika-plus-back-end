
import './App.css'
import {useState,useEffect} from 'react';
import { DATA } from './data';
const alphabet=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];

function App() {
  const [index,setIndex]=useState(0);
  const [question,setQuestion] =useState('');
  const [answer,setAnswer] = useState('');
  const [answerArray,setAnswerArray] = useState([]);
  const [keywords,setKeywords]=useState([]);
  
  const shuffle = (array)=>{
    return array.sort(()=>Math.random()-0.5);
  }

  /*const setKeyword =(keyword)=>{
    if(keywords.length<answer.length){
  keywords.push(keyword);
  setKeywords(...[keywords]);
  }
  }*/

  const setKeyword = (keyword) => {
    if(keywords.length<answer.length){
    const newKeywords = [...keywords, keyword];
    
    setKeywords(newKeywords);}
  };
  

  useEffect(()=>{
    const answer =DATA[index].answer.toLowerCase();
    setAnswer(answer);
    setQuestion(DATA[index].question);
    const stringToArray = answer.split("");
    for(let i =0; i<3;i++){
      stringToArray.push(alphabet[Math.floor(Math.random()*alphabet.length)]);
    }
    const alphabetLowerData = stringToArray.map((answer)=>answer.toLowerCase());
    setAnswerArray(shuffle(alphabetLowerData));
    console.log(shuffle(alphabetLowerData));
    
    
  },[]);

  /*const removeKeyword=(index)=>{
    keywords.splice(index,1);
    setKeywords(...keywords);
  }*/

  const removeKeyword = (indexToRemove) => {
    const newKeywords = keywords.filter((_, index) => index !== indexToRemove);
    setKeywords(newKeywords);
  };
  

  return(
  <div className="App">
    <div>      
      <span>{question} </span>
    </div>  
    <div>
      {keywords.map((item,index) =>(
        <span onClick={()=>removeKeyword(index)} key={index}>
          {item}
        </span>
      ))}
    </div>
    <div>
      {
        answerArray.map((item,index)=>(
          <button key ={index} onClick ={()=>setKeyword(item)}>
          {item}
          </button>
        ))
      }
    </div>
  </div>
  );      
}

export default App
