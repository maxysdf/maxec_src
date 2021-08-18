import styles from "../styles/LoginLayout.module.css"

export default function LoginLayout({children}) {
    return (
        <>
        <div className={styles.login}>
            {children}
        </div>
        </>
    )
}