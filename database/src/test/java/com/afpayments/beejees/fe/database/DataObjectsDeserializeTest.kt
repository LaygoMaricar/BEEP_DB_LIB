package com.afpayments.beejees.fe.database

import com.afpayments.beejees.fe.database.dataObjects.*
import kotlinx.serialization.json.Json
import org.junit.Assert
import org.junit.Test

class DataObjectsDeserializeTest {

    @Test
    fun cardSet(){
        val json = "{ \"profileIds\": 2, \"accountRanges\": [], \"vehicleTypes\": [] }"
        var cardSet = CardSet.fromString(json)
        Assert.assertTrue(cardSet.profileIds == 2L)
    }

    @Test
    fun cellTowerSegment(){
        //NO DATA AVAILABLE YET
    }

    @Test
    fun coordinate(){
        val json = "{ \"lat\": \"14.557075\", \"lon\": \"121.0235217\" }"
        var coordinate = Coordinate.fromString(json)
        Assert.assertTrue(coordinate.lat == "14.557075")
    }

    @Test
    fun discount(){
        val json = "{ \"id\": 12622, \"discount\": 20, \"roundingMethod\": \"UP\", \"roundingAccuracy\": 100, \"effective\": { \"from\": \"2019-08-07T00:00:00+08:00\", \"to\": \"2020-08-07T00:00:00+08:00\" }, \"activeAt\": [], \"appliesTo\": [ { \"profileIds\": 21, \"accountRanges\": [], \"vehicleTypes\": [] }, { \"profileIds\": 2, \"accountRanges\": [], \"vehicleTypes\": [] }, { \"profileIds\": 17, \"accountRanges\": [], \"vehicleTypes\": [] }, { \"profileIds\": 3, \"accountRanges\": [], \"vehicleTypes\": [] } ], \"accumulative\": null, \"prorated\": null }"
        var discount = Discount.fromString(json)
        Assert.assertTrue(discount.id == 12622L)
    }

    @Test
    fun distanceBasedFareTable(){
        val json = "{ \"id\": 9262, \"baseFare\": { \"amount\": 5007, \"distance\": 4000 }, \"incrementalFares\": [ { \"amount\": 200, \"distance\": 1000, \"startDistance\": 4000 } ], \"effective\": { \"from\": \"2019-08-11T19:50:10+08:00\", \"to\": \"2019-08-12T19:50:10+08:00\" }, \"activeAt\": [], \"appliesTo\": [], \"accumulative\": null, \"prorated\": null }"
        var distanceBasedFareTable = DistanceBasedFareTable.fromString(json)
        Assert.assertTrue(distanceBasedFareTable.id == 9262L)
    }

    @Test
    fun effectivePeriod(){
        val json = "{ \"from\": \"2019-01-01T00:00:00+08:00\", \"to\": \"2022-01-01T00:00:00+08:00\" }"
        var effectivePeriod = EffectivePeriod.fromString(json)
        Assert.assertTrue(effectivePeriod.from == "2019-01-01T00:00:00+08:00")
    }

    @Test
    fun externalId(){
        //NO DATA
    }


    @Test
    fun fixedBasedFareTable(){
        val json = "{ \"id\": 1, \"amount\": 1300, \"effective\": { \"from\": \"2019-01-01T00:00:00+08:00\", \"to\": \"2022-01-01T00:00:00+08:00\" }, \"activeAt\": [], \"appliesTo\": [], \"accumulative\": false, \"prorated\": false }"
        var fixedBasedFareTable = FixedBasedFareTable.fromString(json)
        Assert.assertTrue(fixedBasedFareTable.id == 1L)
    }

    @Test
    fun incrementalFare(){
        val json = "{ \"amount\": 200, \"distance\": 1000, \"startDistance\": 4000 }"
        var incrementalFare = IncrementalFare.fromString(json)
        Assert.assertTrue(incrementalFare.amount == 200L)
    }

    @Test
    fun incrementalFee(){
        //NO DATA
    }

    @Test
    fun parameter(){
        val json = "{ \"name\": \"NumberOfIncrements\", \"value\": \"2\", \"type\": \"Int64\", \"effective\": { \"from\": \"2019-05-08T00:00:00+08:00\", \"to\": \"2035-05-08T00:00:00+08:00\" }, \"activeAt\": [] }"
        var parameter = Parameter.fromString(json)
        Assert.assertTrue(parameter.value == "2")
    }

    @Test
    fun route(){
        val json = "{ \"id\": 111, \"shortName\": \"MIRZI\", \"longName\": \"MIRZI\", \"fareStrategy\": \"debit_credit\", \"fareTables\": { \"distanceBased\": [ 103 ], \"stopBased\": [], \"discounts\": [ 101 ], \"fixedBased\": [] }, \"cellTowerSegments\": [], \"segments\": [ { \"seq\": 2289, \"start\": { \"lat\": \"14.55661667\", \"lon\": \"121.0239417\" }, \"end\": { \"lat\": \"14.55683\", \"lon\": \"121.0237983\" }, \"len\": 28, \"dir\": 15 }, { \"seq\": 2290, \"start\": { \"lat\": \"14.55683\", \"lon\": \"121.0237983\" }, \"end\": { \"lat\": \"14.556855\", \"lon\": \"121.0236717\" }, \"len\": 14, \"dir\": 64 }, { \"seq\": 2291, \"start\": { \"lat\": \"14.556855\", \"lon\": \"121.0236717\" }, \"end\": { \"lat\": \"14.55688667\", \"lon\": \"121.0235767\" }, \"len\": 11, \"dir\": 51 }, { \"seq\": 2292, \"start\": { \"lat\": \"14.55688667\", \"lon\": \"121.0235767\" }, \"end\": { \"lat\": \"14.556783\", \"lon\": \"121.0232965\" }, \"len\": 32, \"dir\": 132 }, { \"seq\": 2293, \"start\": { \"lat\": \"14.556783\", \"lon\": \"121.0232965\" }, \"end\": { \"lat\": \"14.556985\", \"lon\": \"121.02354\" }, \"len\": 35, \"dir\": -26 }, { \"seq\": 2294, \"start\": { \"lat\": \"14.556985\", \"lon\": \"121.02354\" }, \"end\": { \"lat\": \"14.556985\", \"lon\": \"121.02354\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2295, \"start\": { \"lat\": \"14.556985\", \"lon\": \"121.02354\" }, \"end\": { \"lat\": \"14.557075\", \"lon\": \"121.0235217\" }, \"len\": 10, \"dir\": 5 }, { \"seq\": 2296, \"start\": { \"lat\": \"14.557075\", \"lon\": \"121.0235217\" }, \"end\": { \"lat\": \"14.557075\", \"lon\": \"121.0235217\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2297, \"start\": { \"lat\": \"14.557075\", \"lon\": \"121.0235217\" }, \"end\": { \"lat\": \"14.55713\", \"lon\": \"121.0236267\" }, \"len\": 13, \"dir\": -38 }, { \"seq\": 2298, \"start\": { \"lat\": \"14.55713\", \"lon\": \"121.0236267\" }, \"end\": { \"lat\": \"14.55717167\", \"lon\": \"121.0237283\" }, \"len\": 12, \"dir\": -45 }, { \"seq\": 2299, \"start\": { \"lat\": \"14.55717167\", \"lon\": \"121.0237283\" }, \"end\": { \"lat\": \"14.55708333\", \"lon\": \"121.0238017\" }, \"len\": 13, \"dir\": -161 }, { \"seq\": 2300, \"start\": { \"lat\": \"14.55708333\", \"lon\": \"121.0238017\" }, \"end\": { \"lat\": \"14.55707167\", \"lon\": \"121.02392\" }, \"len\": 13, \"dir\": -104 }, { \"seq\": 2301, \"start\": { \"lat\": \"14.55707167\", \"lon\": \"121.02392\" }, \"end\": { \"lat\": \"14.55707167\", \"lon\": \"121.02392\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2302, \"start\": { \"lat\": \"14.55707167\", \"lon\": \"121.02392\" }, \"end\": { \"lat\": \"14.55706\", \"lon\": \"121.0240383\" }, \"len\": 13, \"dir\": -104 }, { \"seq\": 2303, \"start\": { \"lat\": \"14.55706\", \"lon\": \"121.0240383\" }, \"end\": { \"lat\": \"14.55706333\", \"lon\": \"121.02416\" }, \"len\": 13, \"dir\": -86 }, { \"seq\": 2304, \"start\": { \"lat\": \"14.55706333\", \"lon\": \"121.02416\" }, \"end\": { \"lat\": \"14.55703833\", \"lon\": \"121.0242817\" }, \"len\": 13, \"dir\": -117 }, { \"seq\": 2305, \"start\": { \"lat\": \"14.55703833\", \"lon\": \"121.0242817\" }, \"end\": { \"lat\": \"14.55697333\", \"lon\": \"121.024375\" }, \"len\": 12, \"dir\": -150 }, { \"seq\": 2306, \"start\": { \"lat\": \"14.55697333\", \"lon\": \"121.024375\" }, \"end\": { \"lat\": \"14.55692833\", \"lon\": \"121.0244567\" }, \"len\": 10, \"dir\": -144 }, { \"seq\": 2307, \"start\": { \"lat\": \"14.55692833\", \"lon\": \"121.0244567\" }, \"end\": { \"lat\": \"14.55692833\", \"lon\": \"121.0244567\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2308, \"start\": { \"lat\": \"14.55692833\", \"lon\": \"121.0244567\" }, \"end\": { \"lat\": \"14.55625\", \"lon\": \"121.02473\" }, \"len\": 81, \"dir\": -171 }, { \"seq\": 2309, \"start\": { \"lat\": \"14.55625\", \"lon\": \"121.02473\" }, \"end\": { \"lat\": \"14.55676\", \"lon\": \"121.0246383\" }, \"len\": 58, \"dir\": 4 }, { \"seq\": 2310, \"start\": { \"lat\": \"14.55676\", \"lon\": \"121.0246383\" }, \"end\": { \"lat\": \"14.556635\", \"lon\": \"121.0248183\" }, \"len\": 24, \"dir\": -150 }, { \"seq\": 2311, \"start\": { \"lat\": \"14.556635\", \"lon\": \"121.0248183\" }, \"end\": { \"lat\": \"14.55653\", \"lon\": \"121.0249967\" }, \"len\": 22, \"dir\": -145 }, { \"seq\": 2312, \"start\": { \"lat\": \"14.55653\", \"lon\": \"121.0249967\" }, \"end\": { \"lat\": \"14.55642167\", \"lon\": \"121.02501\" }, \"len\": 12, \"dir\": -177 }, { \"seq\": 2313, \"start\": { \"lat\": \"14.55642167\", \"lon\": \"121.02501\" }, \"end\": { \"lat\": \"14.55642167\", \"lon\": \"121.02501\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2314, \"start\": { \"lat\": \"14.55642167\", \"lon\": \"121.02501\" }, \"end\": { \"lat\": \"14.55632\", \"lon\": \"121.02503\" }, \"len\": 12, \"dir\": -175 }, { \"seq\": 2315, \"start\": { \"lat\": \"14.55632\", \"lon\": \"121.02503\" }, \"end\": { \"lat\": \"14.55632\", \"lon\": \"121.02503\" }, \"len\": 0, \"dir\": 0 }, { \"seq\": 2316, \"start\": { \"lat\": \"14.55632\", \"lon\": \"121.02503\" }, \"end\": { \"lat\": \"14.55626833\", \"lon\": \"121.0249467\" }, \"len\": 11, \"dir\": 147 }, { \"seq\": 2317, \"start\": { \"lat\": \"14.55626833\", \"lon\": \"121.0249467\" }, \"end\": { \"lat\": \"14.55632\", \"lon\": \"121.024835\" }, \"len\": 13, \"dir\": 41 }, { \"seq\": 2318, \"start\": { \"lat\": \"14.55632\", \"lon\": \"121.024835\" }, \"end\": { \"lat\": \"14.556365\", \"lon\": \"121.0247333\" }, \"len\": 12, \"dir\": 43 }, { \"seq\": 2319, \"start\": { \"lat\": \"14.556365\", \"lon\": \"121.0247333\" }, \"end\": { \"lat\": \"14.55640333\", \"lon\": \"121.0246417\" }, \"len\": 11, \"dir\": 44 }, { \"seq\": 2320, \"start\": { \"lat\": \"14.55640333\", \"lon\": \"121.0246417\" }, \"end\": { \"lat\": \"14.55645\", \"lon\": \"121.0245433\" }, \"len\": 12, \"dir\": 41 }, { \"seq\": 2321, \"start\": { \"lat\": \"14.55645\", \"lon\": \"121.0245433\" }, \"end\": { \"lat\": \"14.556465\", \"lon\": \"121.0244283\" }, \"len\": 12, \"dir\": 72 }, { \"seq\": 2322, \"start\": { \"lat\": \"14.556465\", \"lon\": \"121.0244283\" }, \"end\": { \"lat\": \"14.55649333\", \"lon\": \"121.0243133\" }, \"len\": 13, \"dir\": 59 }, { \"seq\": 2323, \"start\": { \"lat\": \"14.55649333\", \"lon\": \"121.0243133\" }, \"end\": { \"lat\": \"14.55652333\", \"lon\": \"121.024195\" }, \"len\": 13, \"dir\": 58 }, { \"seq\": 2324, \"start\": { \"lat\": \"14.55652333\", \"lon\": \"121.024195\" }, \"end\": { \"lat\": \"14.55648\", \"lon\": \"121.0241117\" }, \"len\": 10, \"dir\": 142 }, { \"seq\": 2325, \"start\": { \"lat\": \"14.55648\", \"lon\": \"121.0241117\" }, \"end\": { \"lat\": \"14.556395\", \"lon\": \"121.02403\" }, \"len\": 13, \"dir\": 159 }, { \"seq\": 2326, \"start\": { \"lat\": \"14.556395\", \"lon\": \"121.02403\" }, \"end\": { \"lat\": \"14.55631667\", \"lon\": \"121.0239317\" }, \"len\": 14, \"dir\": 153 }, { \"seq\": 2327, \"start\": { \"lat\": \"14.55631667\", \"lon\": \"121.0239317\" }, \"end\": { \"lat\": \"14.55620833\", \"lon\": \"121.02388\" }, \"len\": 13, \"dir\": 169 }, { \"seq\": 2328, \"start\": { \"lat\": \"14.55620833\", \"lon\": \"121.02388\" }, \"end\": { \"lat\": \"14.55612333\", \"lon\": \"121.0238317\" }, \"len\": 11, \"dir\": 167 }, { \"seq\": 2329, \"start\": { \"lat\": \"14.55612333\", \"lon\": \"121.0238317\" }, \"end\": { \"lat\": \"14.5561976\", \"lon\": \"121.0250884\" }, \"len\": 136, \"dir\": -82 }, { \"seq\": 2330, \"start\": { \"lat\": \"14.5561976\", \"lon\": \"121.0250884\" }, \"end\": { \"lat\": \"14.55661667\", \"lon\": \"121.0239417\" }, \"len\": 132, \"dir\": 48 } ], \"stops\": [] }"
        var route = Route.fromString(json)
        Assert.assertTrue(route.id == 111L)
    }

    @Test
    fun segment(){
        val json = "{ \"seq\": 2331, \"start\": { \"lat\": \"14.55552167\", \"lon\": \"121.023055\" }, \"end\": { \"lat\": \"14.55551667\", \"lon\": \"121.022945\" }, \"len\": 12, \"dir\": 96 }"
        var segment = Segment.fromString(json)
        Assert.assertTrue(segment.seq == 2331L)
    }

    @Test
    fun stop(){
        val json = "{ \"id\": 1, \"shortName\": \"Water\", \"longName\": \"Water\", \"coordinate\": { \"lat\": null, \"lon\": null }, \"range\": 0, \"direction\": null, \"activeAt\": [] }"
        var stop = Stop.fromString(json)
        Assert.assertTrue(stop.id == 1L)
    }

    @Test
    fun stopBasedFareTable(){
        val json = "{ \"id\": 1, \"fareMatrix\": \"[[0,2000,2500],[2000,0,1000],[2500,1000,0]]\", \"effective\": { \"from\": \"2019-01-01T00:00:00+08:00\", \"to\": \"2022-01-01T00:00:00+08:00\" }, \"activeAt\": [], \"appliesTo\": [], \"accumulative\": false, \"prorated\": false }"
        var stopBasedFareTable = StopBasedFareTable.fromString(json)
        Assert.assertTrue(stopBasedFareTable.id == 1L)
    }

    @Test
    fun timeBasedFeeTable(){
        //NO DATA
    }

    @Test
    fun timeInterval(){
        val json = "{\n" +
                "                        \"at\": [\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true,\n" +
                "                            true\n" +
                "                        ],\n" +
                "                        \"on\": null\n" +
                "                    }"
        var timeInterval = TimeInterval.fromString(json)
        Assert.assertTrue(timeInterval.at!![0])
    }

    @Test
    fun user(){
        val json = "{ \"id\": 262001, \"companyId\": \"AF262001\", \"shortName\": \"BGC\", \"longName\": \"BGC BUS\", \"idCards\": [ { \"uid\": \"04634cc29b3380\", \"role\": \"Driver\", \"effective\": { \"from\": \"2019-08-14T14:56:45+08:00\", \"to\": \"2019-08-15T14:56:45+08:00\" } }, { \"uid\": \"04653552133b80\", \"role\": \"Dispatcher\", \"effective\": { \"from\": \"2019-08-11T17:40:32+08:00\", \"to\": \"2019-08-12T17:40:32+08:00\" } }, { \"uid\": \"042D1C52133B80\", \"role\": \"Driver\", \"effective\": { \"from\": \"2019-08-11T17:47:41+08:00\", \"to\": \"2019-08-12T17:47:41+08:00\" } }, { \"uid\": \"043f230a1b4480\", \"role\": \"Dispatcher\", \"effective\": { \"from\": \"2019-08-14T14:57:25+08:00\", \"to\": \"2019-08-15T14:57:25+08:00\" } } ], \"effective\": { \"from\": \"2019-08-11T17:34:54+08:00\", \"to\": \"2019-08-12T17:34:54+08:00\" } }"
        var user = User.fromString(json)
        Assert.assertTrue(user.id == 262001L)
    }

    @Test
    fun vehicle(){
        val json = "{ \"id\": 2341, \"shortIdentifier\": \"P2F_BGC\", \"longIdentifier\": \"P2F BGC Bus\", \"externalIds\": [], \"idCards\": [], \"effective\": { \"from\": \"2019-04-23T00:00:00+08:00\", \"to\": \"2019-04-24T00:00:00+08:00\" } }"
        var vehicle = Vehicle.fromString(json)
        Assert.assertTrue(vehicle.id == 2341L)
    }

    @Test
    fun printTemplate(){
        val json = "{ \"id\": 1, \"templateType\": \"END_OF_SHIFT_REPORT\", \"templateName\": \"PATEROS_END_OF_SHIFT\", \"template\": [ \"T|^|=|=|Cashier End Of Shift Report\", \"LF|CENTER\", \"T|<|=|=|Start\", \"V|>|=|=|driverShiftStart|YY-MM-dd HH:mm:ss\", \"LF|CENTER\", \"T|<|=|=|End\", \"V|>|=|=|dateNow|YY-MM-dd HH:mm:ss\", \"LF|CENTER\", \"T|<|=|=|Operator\", \"V|>|=|=|participantShortName|..20\", \"LF|CENTER\", \"T|<|=|=|Terminal\", \"V|>|=|=|terminalId|..20\", \"LF|CENTER\", \"T|<|=|=|Cashier\", \"V|>|=|=|driverId|..20\", \"LF|CENTER\", \"T|<|=|=|Route\", \"V|>|=|=|routeNames|..20\", \"LF|CENTER\", \"T|<|=|=|MTC Start\", \"V|>|=|=|oldMtc|..20\", \"LF|CENTER\", \"T|<|=|=|MTC End\", \"V|>|=|=|mtc|..20\", \"LF|CENTER\", \"LF|CENTER\", \"T|<|=|=|AYALA_U Total\", \"V|>|=|=|routeTotal.AYALA_U.amount|PHP%5.2f\", \"LF|CENTER\", \"T|<|=|=|Cash Total\", \"V|>|=|=|totalRegular|PHP%5.2f\", \"LF|CENTER\", \"T|<|=|=|Cash Discount Total\", \"V|>|=|=|totalDiscount|PHP%5.2f\", \"LF|CENTER\", \"T|<|=|=|beep Total\", \"V|>|=|=|totalBeep|PHP%5.2f\", \"LF|CENTER\", \"LF|CENTER\", \"T|<|=|=|Total\", \"V|>|=|=|totalAmount|PHP%5.2f\", \"LF\", \"LF\", \"LF\", \"LF\", \"CUT|PARTIAL\" ], \"effective\": { \"from\": \"2019-01-01T00:00:00+08:00\", \"to\": \"2022-01-01T00:00:00+08:00\" } }"
        var printTemplate = PrintTemplate.fromString(json)
        Assert.assertTrue(printTemplate.id!! == 1L)
    }
}