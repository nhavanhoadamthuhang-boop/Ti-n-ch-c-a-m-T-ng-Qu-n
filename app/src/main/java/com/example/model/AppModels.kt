package com.example.model

import java.util.UUID

// Navigation Tabs
enum class AppTab(val title: String, val subtitle: String) {
    GAME_CREATOR("Công Cụ Sáng Tạo", "Minecraft, SimCity, TheoTown & City Island"),
    VIETNAM_KNOWLEDGE("Tri Thức Việt Nam", "Lịch sử, Địa danh, Bác Hồ, Tiếng Việt & Tử vi"),
    MEDIA_SIMULATOR("Đa Phương Tiện & Giả Lập", "Pixel Art, 3D LEGO, Speedtest, QR & Giả lập OS"),
    PROJECT_INFO("Hồ Sơ & Cài Đặt", "Tác giả Đàm Tường Quân, Lịch sử 2026.92.0 & VIP")
}

// Minecraft Tools
data class MinecraftManifest(
    val formatVersion: Int = 2,
    val name: String,
    val description: String,
    val uuidHeader: String = UUID.randomUUID().toString(),
    val uuidModule: String = UUID.randomUUID().toString(),
    val packType: String = "data", // data or resources or world_template
    val minEngineVersion: List<Int> = listOf(1, 20, 0)
)

data class MinecraftMobConfig(
    val mobName: String = "Quân Vương Đại Đế",
    val isBoss: Boolean = true,
    val healthPoints: Int = 1000,
    val expReward: Int = 400,
    val mobFamily: String = "boss, undead, monster",
    val spawnBiome: String = "Pale Garden, Deep Dark",
    val customDrop: String = "netherite_ingot, dragon_breath, enchanted_golden_apple"
)

data class MinecraftSuperflatPreset(
    val layerConfig: String = "Stone +1, Gravel +1, Cherry Log +4, Pale Oak Log +4, Sulfur +4",
    val spawnX: Int = 280,
    val spawnY: Int = -60,
    val spawnZ: Int = 80,
    val spawnRadius: Int = 12,
    val alwaysDay: Boolean = true,
    val weatherCycle: Boolean = false,
    val keepInventory: Boolean = true
)

// SimCity BuildIt State
data class SimCityConfig(
    val cityName: String = "Thành Phố Tri Thức 2026",
    val mayorName: String = "Đàm Tường Quân",
    val level: Int = 100,
    val population: Long = 12000000L,
    val happinessPercent: Int = 100,
    val simoleons: Long = 1111111120L,
    val simcash: Long = 1111111120L,
    val goldenKeys: Long = 1111111120L,
    val platinumKeys: Long = 1111111120L,
    val neoSimoleons: Long = 1111111120L,
    val warSimoleons: Long = 1111111120L,
    val maxWarDisasterLevel: Int = 20,
    val totalStorageCapacity: Int = 1000
)

// TheoTown Plugin Config
data class TheoTownPlugin(
    val pluginId: String = "\$vietnam_knowledge_hub_2026",
    val title: String = "Tòa Nhà Tri Thức Việt Nam",
    val description: String = "Công trình trung tâm văn hóa và công nghệ đa năng Đàm Tường Quân",
    val category: String = "Quản lý / Văn hóa / Công nghệ",
    val width: Int = 2,
    val height: Int = 2,
    val price: Int = 50000,
    val monthlyPrice: Int = 250,
    val hasWinterFrame: Boolean = true,
    val hasNightLight: Boolean = true,
    val hasParticleEffect: Boolean = true
)

// City Island 6 Config
data class CityIslandConfig(
    val islandName: String = "Đảo Thiên Đường Cao Bằng",
    val level: Int = 99,
    val cashBalance: Long = 999999999L,
    val goldBalance: Long = 999999999L,
    val activationCode: String = "CI${(100000..999999).random()}"
)

// Cities: Skylines & Cities: Skylines II Config
data class CitiesSkylinesConfig(
    val cityName: String = "Metropolis Tri Thức 2026",
    val mayorName: String = "Đàm Tường Quân",
    val population: Long = 450000L,
    val trafficFlowPercent: Int = 88,
    val treasuryBalance: Long = 85000000L,
    val weeklyIncome: Long = 250000L,
    val selectedInterchange: String = "Turbine 4-Way Interchange",
    val taxRatePercent: Int = 12,
    val ricoDemandResidential: Int = 85,
    val ricoDemandCommercial: Int = 60,
    val ricoDemandIndustrial: Int = 45,
    val ricoDemandOffice: Int = 90,
    val enableFreePublicTransport: Boolean = true,
    val enableHighTechHousing: Boolean = true,
    val tmpeBypassJunctions: Boolean = true
)

// Hồ Chí Minh Historical Milestones
data class UncleHoTimelineEvent(
    val year: String,
    val title: String,
    val location: String,
    val description: String,
    val coordinateNote: String
)

// Vietnam Infrastructure & Geography
data class InfrastructureItem(
    val title: String,
    val category: String, // Cao tốc, Đường sắt, Cầu vượt biển, Hầm đường bộ, Cáp treo, Đèo nổi tiếng
    val lengthOrSpec: String,
    val routeLocation: String,
    val highlight: String
)

// Ports, Fishing Harbors & Oil Facilities
data class PortAndEnergyItem(
    val name: String,
    val type: String, // Cảng nước sâu, Cảng cá, Cảng dầu mỏ & Năng lượng, Bến du thuyền
    val location: String,
    val capacity: String,
    val description: String
)

// Hospitals in Vietnam
data class HospitalItem(
    val name: String,
    val level: String, // Hạng Đặc biệt, Tuyến Trung ương, Tuyến Tỉnh
    val location: String,
    val specialties: String,
    val scaleBeds: String
)

// Famous Landmarks in Vietnam & Worldwide
data class FamousLandmarkItem(
    val name: String,
    val region: String, // Việt Nam, Châu Á, Châu Âu, Châu Mỹ, Châu Phi
    val country: String,
    val architecturalStyle: String,
    val significance: String
)

// Famous Terraced Rice Fields in Vietnam
data class TerracedFieldItem(
    val name: String,
    val province: String,
    val areaHectares: String,
    val bestSeason: String, // Mùa lúa chín vàng (Tháng 9 - 10), Mùa nước đổ (Tháng 5 - 6)
    val nationalHeritageStatus: String, // Di tích Quốc gia Đặc biệt, Di tích Quốc gia
    val ethnicGroups: String, // Dân tộc H'Mông, Dao, La Chí, Tày, Thái, Nùng
    val highlights: String,
    val famousSpots: String // Đồi mâm xôi La Pán Tẩn, Đồi móng ngựa Mồ Dề...
)

// Famous National Parks in Vietnam
data class NationalParkItem(
    val name: String,
    val province: String,
    val region: String, // Miền Bắc, Miền Trung, Miền Nam
    val areaHectares: String,
    val unescoRamsarTitle: String, // Di sản Thiên nhiên Thế giới, Khu Dự trữ Sinh quyển, Ramsar, Vườn Di sản ASEAN
    val iconicFloraFauna: String, // Sơn Đoòng, Sếu đầu đỏ, Voọc Cát Bà, Voi, Bò Tót, Rừng Rêu
    val highlights: String,
    val ecotourismSpots: String
)

// Famous Zoos & Safari Parks in Vietnam
data class ZooItem(
    val name: String,
    val province: String,
    val region: String, // Miền Bắc, Miền Trung, Miền Nam
    val areaHectares: String,
    val type: String, // Safari Bán Hoang Dã, Vườn Thú Mở, Sở Thú Lịch Sử, River Safari, Thân Thiện Tương Tác
    val totalSpeciesAndAnimals: String,
    val iconicAnimals: String,
    val highlights: String,
    val famousExperiences: String
)

// Tiếng Việt Lớp 1
data class AlphabetLetter(
    val letter: String,
    val exampleWord: String,
    val meaning: String,
    val phonetic: String
)

// Astronomy & Horoscope
data class SolarLunarData(
    val sunrise: String = "05:42",
    val sunset: String = "18:28",
    val moonrise: String = "19:15",
    val moonPhase: String = "Trăng Tròn (Vọng - Rằm)",
    val illumination: String = "98%",
    val compassAzimuth: Float = 68.5f,
    val solarNoon: String = "12:05"
)

// Project Changelog Entry
data class ProjectHistoryMilestone(
    val date: String,
    val version: String,
    val title: String,
    val detail: String,
    val apkSizeMB: Int
)
