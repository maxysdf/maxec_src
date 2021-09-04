import Script from "next/script"
import Link from "next/link"
import { useEffect } from "react";

export default function IndexDoTW() {
    useEffect(() => {
        /*------------------
            CountDown
        --------------------*/
        // For demo preview
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();

        if(mm == 12) {
            mm = '01';
            yyyy = yyyy + 1;
        } else {
            mm = parseInt(mm) + 1;
            mm = String(mm).padStart(2, '0');
        }
        var timerdate = mm + '/' + dd + '/' + yyyy;
        // For demo preview end

        console.log(timerdate);


        // Use this for real timer date
        /* var timerdate = "2020/01/01"; */

        $("#countdown").countdown(timerdate, function(event) {
            $(this).html(event.strftime("<div class='cd-item'><span>%D</span> <p>Days</p> </div>" + "<div class='cd-item'><span>%H</span> <p>Hrs</p> </div>" + "<div class='cd-item'><span>%M</span> <p>Mins</p> </div>" + "<div class='cd-item'><span>%S</span> <p>Secs</p> </div>"));
        });
    }, []);
    return (
        <>
        <section className="deal-of-week set-bg spad" data-setbg="/images/time-bg.jpg">
            <div className="container">
                <div className="col-lg-6 text-center">
                    <div className="section-title">
                        <h2>Deal Of The Week</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed<br /> do ipsum dolor sit amet,
                            consectetur adipisicing elit </p>
                        <div className="product-price">
                            $35.00
                            <span>/ HanBag</span>
                        </div>
                    </div>
                    <div className="countdown-timer" id="countdown">
                        <div className="cd-item">
                            <span>56</span>
                            <p>Days</p>
                        </div>
                        <div className="cd-item">
                            <span>12</span>
                            <p>Hrs</p>
                        </div>
                        <div className="cd-item">
                            <span>40</span>
                            <p>Mins</p>
                        </div>
                        <div className="cd-item">
                            <span>52</span>
                            <p>Secs</p>
                        </div>
                    </div>
                    <a href="#" className="primary-btn">Shop Now</a>
                </div>
            </div>
        </section>
        </>
    );
}