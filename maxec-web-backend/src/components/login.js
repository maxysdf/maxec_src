import { useRouter } from "next/dist/client/router";
import { useForm } from "react-hook-form";
import styles from "../styles/Login.module.css"


export default function Login() {
    const router = useRouter();

    const { register, handleSubmit, getValues } = useForm({
        defaultValues: {
            username: '',
            password: '',
        }
    });
    
    const loginClick = (data) => {
        // check login

        router.push('/product/list');
    };


    return (
        <div className={`container ${styles.container}`} >
            <div className="d-flex justify-content-center h-100">
                <div className={`card ${styles.card}`}>
                    <div className={`card-header ${styles.cardHeader}`}>
                        <h3>登入</h3>
                        <div className={`d-flex justify-content-end ${styles.social_icon}`}>
                            <span><i className="fab fa-facebook-square"></i></span>
                            <span><i className="fab fa-google-plus-square"></i></span>
                            <span><i className="fab fa-twitter-square"></i></span>
                        </div>
                    </div>
                    <div className="card-body">
                        <form autoComplete="off">
                            <div className="input-group form-group">
                                <div className={`input-group-prepend ${styles.inputGroupPrepend}`}>
                                    <span className="input-group-text"><i className="fas fa-user"></i></span>
                                </div>
                                <input type="text" className="form-control" placeholder="username" {...register('username')}/>
                                
                            </div>
                            <div className="input-group form-group">
                                <div className={`input-group-prepend ${styles.inputGroupPrepend}`}>
                                    <span className="input-group-text"><i className="fas fa-key"></i></span>
                                </div>
                                <input type="password" className="form-control" placeholder="password" {...register('password') } />
                            </div>
                            <div className={`row align-items-center ${styles.remember}`}>
                                <input type="checkbox"/>記得我
                            </div>
                            <div className="form-group">
                                <input type="button" value="登入" className={`btn float-right ${styles.login_btn}`} onClick={handleSubmit(loginClick)} />
                            </div>
                        </form>
                    </div>
                    <div className="card-footer">
                        <div className={`d-flex justify-content-center ${styles.links}`}>
                            沒有帳號?<a href="#">新建</a>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href="#">忘記密碼?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

