package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method("POST")
        url("/bets")
        body([
                playerId: 17732,
                gameId  : 25,
                amount  : 10.00,
                currency: "GBP"

        ])
        headers {
            header("Content-Type", "application/json")
        }
    }

    response {
        status 200
        body("""
            {
                "playerId": 17732,
                "balance": 100,
                "currency": "GBP"
            }
            """)
        headers {
            header(
                    'Content-Type', value(consumer('application/json'), producer('application/json'))
            )
        }
    }
}