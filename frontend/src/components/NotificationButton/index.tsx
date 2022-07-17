import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg'; 
import { BASE_URL } from '../../utils/request';
import './styles.css'

/**
 * 
 * @author Johnny Carvalho
 * @date 2022-07-16
 * 
 * this component is used to display a notification button 
 */

type Props = {
  saleId: number;
}

function handleClick (saleId : number) {
  axios(`${BASE_URL}/sales/${saleId}/notification`)
  .then(response => {
    toast.info("SMS enviado com sucesso!")
    
  })
}

export function NotificationButton( { saleId } : Props ) {
  return (
    <div className="notification-button"
    onClick={() => handleClick(saleId)}>
        <img src={icon} alt="Notification" />
    </div>
  );
}