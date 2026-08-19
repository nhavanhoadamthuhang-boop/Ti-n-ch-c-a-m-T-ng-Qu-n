package com.example.ui

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.DataProvider
import com.example.model.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

data class MainUiState(
    val currentTab: AppTab = AppTab.GAME_CREATOR,
    val isPremium: Boolean = true,
    val dailyLimitRemaining: Int = 11984,
    val maxDailyLimit: Int = 12000,
    val audioVolume: Float = 0.85f,
    val soundEffectsEnabled: Boolean = true,
    
    // Minecraft Tool State
    val mcPackName: String = "Gói Tài Nguyên Tri Thức 2026",
    val mcPackDesc: String = "Tiện ích Minecraft của Đàm Tường Quân - Phiên bản 2026.92.0",
    val mcPackType: String = "data", // "data", "resources", "world_template"
    val mcGeneratedJson: String = "",
    val mcMobConfig: MinecraftMobConfig = MinecraftMobConfig(),
    val mcSuperflatPreset: MinecraftSuperflatPreset = MinecraftSuperflatPreset(),
    val mrBeastScore: Double = 38.5,

    // SimCity State
    val simCityConfig: SimCityConfig = SimCityConfig(),
    val simCityActivationCode: String = "RS88294109",
    val simCityCodeTimeRemainingSeconds: Int = 1800,
    val simCitySelectedZoneSize: String = "100x100 ô",

    // TheoTown State
    val theoTownPlugin: TheoTownPlugin = TheoTownPlugin(),
    val theoTownGeneratedJson: String = "",

    // City Island State
    val cityIslandConfig: CityIslandConfig = CityIslandConfig(),

    // Cities: Skylines State
    val citiesSkylinesConfig: CitiesSkylinesConfig = CitiesSkylinesConfig(),
    val citiesSkylinesGeneratedXml: String = "",

    // Vietnam Knowledge
    val selectedUncleHoMilestoneIndex: Int = 2, // Pác Bó Cao Bằng default
    val selectedLetter: AlphabetLetter = DataProvider.vietnameseAlphabet[0],
    val spokenLetterAudioActive: Boolean = false,
    val simulatedCompassHeading: Float = 68.5f,
    val solarLunarData: SolarLunarData = SolarLunarData(),
    val generatedTvCode: String = "TV99281742",
    val tvCodeUsesLeft: Int = 5,

    // Media & Simulators
    val pixelArtGrid: List<List<Color>> = List(16) { List(16) { Color(0xFF0F3057) } },
    val selectedPixelColor: Color = Color(0xFFE7A03C),
    val qrInputText: String = "https://youtube.com/@quantummakers",
    val qrGeneratedResult: String = "QR_PAYLOAD_ENCODED_VALID_2026",
    
    // Speedtest
    val isTestingSpeed: Boolean = false,
    val pingMs: Int = 12,
    val jitterMs: Int = 2,
    val downloadSpeedMbps: Float = 476.5f,
    val uploadSpeedMbps: Float = 88.2f,

    // 3D LEGO Converter
    val selectedLegoTheme: String = "Creator", // City, Ninjago, Minecraft, Icons, Creator, Friends
    val legoPiecesEstimated: Int = 1420,
    val legoEstimatedCostVnd: Long = 2850000L,

    // System Emulator Specs
    val selectedEmulatorOs: String = "Windows 11 Pro",
    val emulatorRamGb: Int = 16,
    val emulatorRomGb: Int = 512,
    val emulatorResolution: String = "2K (2560x1440)",
    val jailbreakRootActive: Boolean = true,

    // App Audio Feedback Notification
    val lastNotificationMessage: String = "Chào mừng đến với Công Cụ Tri Thức Việt Nam 2026!"
)

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private var speedTestJob: Job? = null
    private var codeTimerJob: Job? = null

    init {
        generateMinecraftManifestJson()
        generateTheoTownJson()
        startCodeCountdown()
    }

    fun setTab(tab: AppTab) {
        _uiState.update { it.copy(currentTab = tab) }
        playFeedbackSound("Chuyển danh mục: ${tab.title}")
    }

    fun togglePremium() {
        _uiState.update { 
            val newVip = !it.isPremium
            it.copy(
                isPremium = newVip,
                maxDailyLimit = if (newVip) 12000 else 1200,
                dailyLimitRemaining = if (newVip) 11984 else 1150
            )
        }
        playFeedbackSound(if (_uiState.value.isPremium) "Đã kích hoạt Đặc quyền VIP Premium" else "Đã chuyển về gói Cơ bản")
    }

    fun setAudioVolume(volume: Float) {
        _uiState.update { it.copy(audioVolume = volume) }
    }

    fun toggleSoundEffects() {
        _uiState.update { it.copy(soundEffectsEnabled = !it.soundEffectsEnabled) }
    }

    // Minecraft Actions
    fun updateMinecraftPack(name: String, desc: String, type: String) {
        _uiState.update { it.copy(mcPackName = name, mcPackDesc = desc, mcPackType = type) }
        generateMinecraftManifestJson()
    }

    fun regenerateMinecraftUuids() {
        generateMinecraftManifestJson()
        playFeedbackSound("Đã tự động tạo mới chuỗi UUID ngẫu nhiên")
    }

    private fun generateMinecraftManifestJson() {
        val s = _uiState.value
        val uuid1 = UUID.randomUUID().toString()
        val uuid2 = UUID.randomUUID().toString()
        val json = when (s.mcPackType) {
            "data" -> """
{
  "format_version": 2,
  "header": {
    "name": "${s.mcPackName}",
    "description": "${s.mcPackDesc}",
    "uuid": "$uuid1",
    "version": [1, 0, 0],
    "min_engine_version": [1, 20, 0]
  },
  "modules": [
    {
      "type": "data",
      "description": "${s.mcPackDesc}",
      "uuid": "$uuid2",
      "version": [1, 0, 0]
    }
  ]
}
""".trimIndent()
            "resources" -> """
{
  "format_version": 2,
  "header": {
    "name": "${s.mcPackName}",
    "description": "${s.mcPackDesc}",
    "uuid": "$uuid1",
    "version": [1, 0, 0],
    "min_engine_version": [1, 20, 0]
  },
  "modules": [
    {
      "type": "resources",
      "description": "${s.mcPackDesc}",
      "uuid": "$uuid2",
      "version": [1, 0, 0]
    }
  ]
}
""".trimIndent()
            else -> """
{
  "format_version": 2,
  "header": {
    "name": "${s.mcPackName}",
    "description": "${s.mcPackDesc}",
    "uuid": "$uuid1",
    "version": [1, 0, 0],
    "base_game_version": "*"
  },
  "modules": [
    {
      "type": "world_template",
      "description": "${s.mcPackDesc}",
      "uuid": "$uuid2",
      "version": [1, 0, 0]
    }
  ]
}
""".trimIndent()
        }
        _uiState.update { it.copy(mcGeneratedJson = json) }
    }

    // SimCity Actions
    fun applyMaxFillSimCity() {
        val maxVal = 1111111120L
        _uiState.update {
            it.copy(
                simCityConfig = it.simCityConfig.copy(
                    simoleons = maxVal,
                    simcash = maxVal,
                    goldenKeys = maxVal,
                    platinumKeys = maxVal,
                    neoSimoleons = maxVal,
                    warSimoleons = maxVal,
                    population = 12000000L,
                    happinessPercent = 100,
                    level = 100
                )
            )
        }
        playFeedbackSound("Đã áp dụng Nạp nhanh tối đa 1.111.111.120 tài nguyên SimCity!")
    }

    fun generateNewSimCityCode() {
        val newCode = "RS${(10000000..99999999).random()}"
        _uiState.update { it.copy(simCityActivationCode = newCode, simCityCodeTimeRemainingSeconds = 1800) }
        playFeedbackSound("Đã sinh mã kích hoạt khôi phục SimCity: $newCode (hiệu lực 30 phút)")
    }

    private fun startCodeCountdown() {
        codeTimerJob?.cancel()
        codeTimerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                _uiState.update {
                    if (it.simCityCodeTimeRemainingSeconds > 0) {
                        it.copy(simCityCodeTimeRemainingSeconds = it.simCityCodeTimeRemainingSeconds - 1)
                    } else it
                }
            }
        }
    }

    // TheoTown Actions
    fun updateTheoTownPlugin(plugin: TheoTownPlugin) {
        _uiState.update { it.copy(theoTownPlugin = plugin) }
        generateTheoTownJson()
    }

    private fun generateTheoTownJson() {
        val p = _uiState.value.theoTownPlugin
        val json = """
[
  {
    "id": "${p.pluginId}",
    "type": "culture",
    "title": "${p.title}",
    "text": "${p.description}",
    "author": "Đàm Tường Quân (Cao Bằng)",
    "width": ${p.width},
    "height": ${p.height},
    "price": ${p.price},
    "monthly price": ${p.monthlyPrice},
    "frames": [
      { "bmp": "knowledge_hub_day.png" },
      ${if (p.hasWinterFrame) "{ \"bmp\": \"knowledge_hub_winter.png\" }" else ""}
    ],
    "night light": ${p.hasNightLight},
    "particles": ${p.hasParticleEffect},
    "influence culture": 500
  }
]
""".trimIndent()
        _uiState.update { it.copy(theoTownGeneratedJson = json) }
    }

    // Cities: Skylines Actions
    fun updateCitiesSkylinesConfig(config: CitiesSkylinesConfig) {
        _uiState.update { it.copy(citiesSkylinesConfig = config) }
        generateCitiesSkylinesXml()
    }

    fun optimizeCitiesSkylinesTraffic() {
        val current = _uiState.value.citiesSkylinesConfig
        val optimized = current.copy(
            trafficFlowPercent = 91,
            tmpeBypassJunctions = true,
            selectedInterchange = "Turbine 4-Way Interchange"
        )
        _uiState.update { it.copy(citiesSkylinesConfig = optimized) }
        generateCitiesSkylinesXml()
        playFeedbackSound("Đã tối ưu hóa lưu lượng giao thông Cities: Skylines lên 91%!")
    }

    private fun generateCitiesSkylinesXml() {
        val c = _uiState.value.citiesSkylinesConfig
        val xml = """
<?xml version="1.0" encoding="utf-8"?>
<!-- Cities: Skylines & Cities: Skylines II Optimization Preset 2026 -->
<CitySaveProfile>
  <Meta>
    <CityName>${c.cityName}</CityName>
    <Mayor>${c.mayorName}</Mayor>
    <Population>${c.population}</Population>
    <TrafficFlow>${c.trafficFlowPercent}%</TrafficFlow>
    <TreasuryBalance>₡${c.treasuryBalance}</TreasuryBalance>
    <WeeklyIncome>+₡${c.weeklyIncome}</WeeklyIncome>
    <TargetInterchange>${c.selectedInterchange}</TargetInterchange>
  </Meta>
  <Policies>
    <UniversalTaxRate>${c.taxRatePercent}%</UniversalTaxRate>
    <FreePublicTransport>${c.enableFreePublicTransport}</FreePublicTransport>
    <HighTechHousing>${c.enableHighTechHousing}</HighTechHousing>
    <TMPE_AdvancedJunctionBypass>${c.tmpeBypassJunctions}</TMPE_AdvancedJunctionBypass>
    <RoundaboutPriorityRule>true</RoundaboutPriorityRule>
  </Policies>
  <RicoDemandDistribution>
    <Residential>${c.ricoDemandResidential}%</Residential>
    <Commercial>${c.ricoDemandCommercial}%</Commercial>
    <Industrial>${c.ricoDemandIndustrial}%</Industrial>
    <Office>${c.ricoDemandOffice}%</Office>
  </RicoDemandDistribution>
</CitySaveProfile>
""".trimIndent()
        _uiState.update { it.copy(citiesSkylinesGeneratedXml = xml) }
    }

    // Vietnam Knowledge Actions
    fun selectUncleHoMilestone(index: Int) {
        _uiState.update { it.copy(selectedUncleHoMilestoneIndex = index) }
        playFeedbackSound("Xem mốc lịch sử: ${DataProvider.uncleHoTimeline[index].title}")
    }

    fun selectAlphabetLetter(letter: AlphabetLetter) {
        _uiState.update { it.copy(selectedLetter = letter, spokenLetterAudioActive = true) }
        viewModelScope.launch {
            delay(1200)
            _uiState.update { it.copy(spokenLetterAudioActive = false) }
        }
        playFeedbackSound("Phát âm chữ cái: ${letter.letter} - ${letter.exampleWord}")
    }

    fun generateNewTvCode() {
        val newCode = "TV${(10000000..99999999).random()}"
        _uiState.update { it.copy(generatedTvCode = newCode, tvCodeUsesLeft = 5) }
        playFeedbackSound("Đã tạo mã kích hoạt tử vi $newCode (nhận thêm 5 lượt tra cứu)")
    }

    // Pixel Art Actions
    fun setPixelColor(r: Int, c: Int) {
        val curGrid = _uiState.value.pixelArtGrid.map { it.toMutableList() }.toMutableList()
        curGrid[r][c] = _uiState.value.selectedPixelColor
        _uiState.update { it.copy(pixelArtGrid = curGrid) }
    }

    fun selectPaletteColor(color: Color) {
        _uiState.update { it.copy(selectedPixelColor = color) }
    }

    fun clearPixelGrid() {
        _uiState.update { it.copy(pixelArtGrid = List(16) { List(16) { Color(0xFF0F3057) } }) }
        playFeedbackSound("Đã làm mới bảng vẽ Pixel Art")
    }

    // Speedtest Actions
    fun startSpeedTest() {
        if (_uiState.value.isTestingSpeed) return
        speedTestJob?.cancel()
        speedTestJob = viewModelScope.launch {
            _uiState.update { it.copy(isTestingSpeed = true, pingMs = 35, downloadSpeedMbps = 0f, uploadSpeedMbps = 0f) }
            playFeedbackSound("Bắt đầu đo kiểm tra tốc độ mạng...")
            
            // Ping & Jitter
            delay(600)
            _uiState.update { it.copy(pingMs = (10..18).random(), jitterMs = (1..4).random()) }
            
            // Download Phase
            for (step in 1..8) {
                delay(300)
                val dl = (step * 55f) + (10..35).random()
                _uiState.update { it.copy(downloadSpeedMbps = dl) }
            }
            _uiState.update { it.copy(downloadSpeedMbps = 476.0f) }
            
            // Upload Phase
            for (step in 1..6) {
                delay(300)
                val ul = (step * 14f) + (2..10).random()
                _uiState.update { it.copy(uploadSpeedMbps = ul) }
            }
            _uiState.update { it.copy(uploadSpeedMbps = 88.0f, isTestingSpeed = false) }
            playFeedbackSound("Đo tốc độ hoàn tất: Tải xuống 476 Mbps, Tải lên 88 Mbps, Ping ${_uiState.value.pingMs}ms")
        }
    }

    // LEGO 3D Actions
    fun selectLegoTheme(theme: String) {
        val pieces = when (theme) {
            "City" -> 850
            "Ninjago" -> 1120
            "Minecraft" -> 980
            "Icons" -> 2450
            "Creator" -> 1420
            "Friends" -> 760
            else -> 1000
        }
        val cost = pieces * 2000L
        _uiState.update { it.copy(selectedLegoTheme = theme, legoPiecesEstimated = pieces, legoEstimatedCostVnd = cost) }
        playFeedbackSound("Chuyển đổi mô hình LEGO dòng: $theme ($pieces mảnh ghép)")
    }

    // Emulator Specs Actions
    fun updateEmulatorSpecs(os: String, ram: Int, rom: Int, res: String) {
        _uiState.update {
            it.copy(
                selectedEmulatorOs = os,
                emulatorRamGb = ram,
                emulatorRomGb = rom,
                emulatorResolution = res
            )
        }
        playFeedbackSound("Cấu hình giả lập $os: $ram GB RAM, $rom GB ROM, $res")
    }

    private fun playFeedbackSound(message: String) {
        _uiState.update { it.copy(lastNotificationMessage = message) }
    }
}
