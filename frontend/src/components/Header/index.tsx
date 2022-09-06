import logo from '../../assets/img/logo.svg'
import './styles.css'

function Header() {
  return(
    <header>
        <div className="dsmeta-logo-container">
            <img src={logo} alt="DSMeta"/>
            <h1>DSMeta</h1>
            <p>Desenvolvido por <a href="https://github.com/ale-vieira" target="_blank">@ale-vieira</a></p>
        </div>
    </header> 
  )
}

export default Header