import icon from '../../assets/img/notification-icon.svg'; 
import './styles.css'

/**
 * 
 * @author Johnny Carvalho
 * @date 2022-07-16
 * 
 * this component is used to display a notification button 
 */
export function NotificationButton() {
  return (
    <div className="notification-button">
        <img src={icon} alt="Notification" />
    </div>
  );
}