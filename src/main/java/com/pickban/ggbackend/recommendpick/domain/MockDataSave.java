package com.pickban.ggbackend.recommendpick.domain;


import com.pickban.ggbackend.recommendpick.domain.entity.Champion;
import com.pickban.ggbackend.recommendpick.domain.repository.ChampionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockDataSave {
    private final ChampionRepository championRepository;

    public void saveTestData() {
        if (championRepository.existsById(1L)) return;
        //                "Aatrox": "266",
        championRepository.save(new Champion(266L, "Aatrox", "top", "1Tier", 96L, List.of()));
        //                "Ahri": "103",
        //                "Akali": "84",
        //                "Akshan": "166",
        //                "Alistar": "12",
        //                "Amumu": "32",
//                "Anivia": "34",
//                "Annie": "1",
//                "Aphelios": "523",
//                "Ashe": "22",
//                "AurelionSol": "136",
//                "Azir": "268",
//                "Bard": "432",
//                "Belveth": "200",
//                "Blitzcrank": "53",
//                "Brand": "63",
//                "Braum": "201",
//                "Caitlyn": "51",
//                "Camille": "164",
        championRepository.save(new Champion(164L, "Camille", "top", "1Tier", 94L, List.of()));
//                "Cassiopeia": "69",
//                "Chogath": "31",
//                "Corki": "42",
//                "Darius": "122",
        championRepository.save(new Champion(122L, "Darius", "top", "1Tier", 100L, List.of()));
//                "Diana": "131",
//                "Draven": "119",
//                "DrMundo": "36",
//                "Ekko": "245",
//                "Elise": "60",
//                "Evelynn": "28",
//                "Ezreal": "81",
//                "Fiddlesticks": "9",
//                "Fiora": "114",
        championRepository.save(new Champion(114L, "Fiora", "top", "2Tier", 93L, List.of()));
//                "Fizz": "105",
//                "Galio": "3",
//                "Gangplank": "41",
        championRepository.save(new Champion(41L, "Gangplank", "top", "2Tier", 80L, List.of()));
//                "Garen": "86",
        championRepository.save(new Champion(86L, "Garen", "top", "2Tier", 89L, List.of()));
//                "Gnar": "150",
//                "Gragas": "79",
//                "Graves": "104",
//                "Gwen": "887",
//                "Hecarim": "120",
//                "Heimerdinger": "74",
//                "Illaoi": "420",
//                "Irelia": "39",
        championRepository.save(new Champion(39L, "Irelia", "top", "2Tier", 85L, List.of()));
//                "Ivern": "427",
//                "Janna": "40",
//                "JarvanIV": "59",
//                "Jax": "24",
        championRepository.save(new Champion(24L, "Jax", "top", "2Tier", 87L, List.of()));
//                "Jayce": "126",
//                "Jhin": "202",
//                "Jinx": "222",
//                "Kaisa": "145",
//                "Kalista": "429",
//                "Karma": "43",
//                "Karthus": "30",
//                "Kassadin": "38",
//                "Katarina": "55",
//                "Kayle": "10",
//                "Kayn": "141",
//                "Kennen": "85",
//                "Khazix": "121",
//                "Kindred": "203",
//                "Kled": "240",
        championRepository.save(new Champion(240L, "Kled", "top", "2Tier", 81L, List.of()));
//                "KogMaw": "96",
//                "Leblanc": "7",
//                "LeeSin": "64",
//                "Leona": "89",
//                "Lillia": "876",
//                "Lissandra": "127",
//                "Lucian": "236",
//                "Lulu": "117",
//                "Lux": "99",
//                "Malphite": "54",
//                "Malzahar": "90",
//                "Maokai": "57",
//                "MasterYi": "11",
//                "MissFortune": "21",
//                "MonkeyKing": "62",
//                "Mordekaiser": "82",
        championRepository.save(new Champion(82L, "Mordekaiser", "top", "1Tier", 95L, List.of()));
//                "Morgana": "25",
//                "Nami": "267",
//                "Nasus": "75",
        championRepository.save(new Champion(75L, "Nasus", "top", "1Tier", 98L, List.of()));
//                "Nautilus": "111",
//                "Neeko": "518",
//                "Nidalee": "76",
//                "Nilah": "895",
//                "Nocturne": "56",
//                "Nunu": "20",
//                "Olaf": "2",
        championRepository.save(new Champion(2L, "Olaf", "top", "2Tier", 92L, List.of()));
//                "Orianna": "61",
//                "Ornn": "516",
        championRepository.save(new Champion(516L, "Shen", "top", "1Tier", 97L, List.of()));
//                "Pantheon": "80",
//                "Poppy": "78",
//                "Pyke": "555",
//                "Qiyana": "246",
//                "Quinn": "133",
//                "Rakan": "497",
//                "Rammus": "33",
//                "RekSai": "421",
//                "Rell": "526",
//                "Renata": "888",
//                "Renekton": "58",
//                "Rengar": "107",
//                "Riven": "92",
        championRepository.save(new Champion(92L, "Riven", "top", "2Tier", 86L, List.of()));
//                "Rumble": "68",
//                "Ryze": "13",
//                "Samira": "360",
//                "Sejuani": "113",
        championRepository.save(new Champion(113L, "Sejuani", "top", "2Tier", 90L, List.of()));
//                "Senna": "235",
//                "Seraphine": "147",
//                "Sett": "875",
        championRepository.save(new Champion(875L, "Sett", "top", "2Tier", 91L, List.of()));
//                "Shaco": "35",
//                "Shen": "98",
        championRepository.save(new Champion(98L, "Shen", "top", "1Tier", 99L, List.of()));
//                "Shyvana": "102",
//                "Singed": "27",
        championRepository.save(new Champion(27L, "Singed", "top", "2Tier", 88L, List.of()));
//                "Sion": "14",
        championRepository.save(new Champion(14L, "Sion", "top", "2Tier", 82L, List.of()));
//                "Sivir": "15",
//                "Skarner": "72",
//                "Sona": "37",
//                "Soraka": "16",
//                "Swain": "50",
//                "Sylas": "517",
//                "Syndra": "134",
//                "TahmKench": "223",
//                "Taliyah": "163",
//                "Talon": "91",
//                "Taric": "44",
//                "Teemo": "17",
//                "Thresh": "412",
//                "Tristana": "18",
//                "Trundle": "48",
//                "Tryndamere": "23",
//                "TwistedFate": "4",
//                "Twitch": "29",
//                "Udyr": "77",
//                "Urgot": "6",
        championRepository.save(new Champion(6L, "Urgot", "top", "2Tier", 84L, List.of()));
//                "Varus": "110",
//                "Vayne": "67",
//                "Veigar": "45",
//                "Velkoz": "161",
//                "Vex": "711",
//                "Vi": "254",
//                "Viego": "234",
//                "Viktor": "112",
//                "Vladimir": "8",
//                "Volibear": "106",
//                "Warwick": "19",
        championRepository.save(new Champion(19L, "Warwick", "top", "2Tier", 83L, List.of()));
//                "Xayah": "498",
//                "Xerath": "101",
//                "XinZhao": "5",
//                "Yasuo": "157",
//                "Yone": "777",
//                "Yorick": "83",
//                "Yuumi": "350",
//                "Zac": "154",
//                "Zed": "238",
//                "Zeri": "221",
//                "Ziggs": "115",
//                "Zilean": "26",
//                "Zoe": "142",
//                "Zyra": "143"
    }

    public Champion findTestData(Long champId) {
        return championRepository.findByChampId(champId).orElseThrow();
    }
}